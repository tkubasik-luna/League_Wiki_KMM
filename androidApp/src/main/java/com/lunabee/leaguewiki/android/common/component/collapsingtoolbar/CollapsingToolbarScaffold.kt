/*
 * Copyright (c) 2021 onebone <me@onebone.me>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lunabee.leaguewiki.android.common.component.collapsingtoolbar

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.Layout
import kotlin.math.absoluteValue
import kotlin.math.max

@Composable
fun CollapsingToolbarScaffold(
    state: CollapsingToolbarScaffoldState,
    modifier: Modifier = Modifier,
    toolbarModifier: Modifier = Modifier,
    toolbar: @Composable () -> Unit,
    body: @Composable () -> Unit,
) {
    val flingBehavior = ScrollableDefaults.flingBehavior()
    val collapsingToolbarState = rememberCollapsingToolbarState(state.collapsedSizePx, state.expendedSizePx)
    val nestedScrollConnection = remember(state.collapsedSizePx, state.expendedSizePx) {
        EnterAlwaysNestedScrollConnection(state.offsetY, collapsingToolbarState, flingBehavior)
    }
    Layout(
        content = {
            CollapsingToolbar(
                modifier = toolbarModifier,
                collapsingToolbarState = collapsingToolbarState,
            ) {
                toolbar()
            }
            body()
        },
        modifier = modifier
            .clipToBounds()
            .nestedScroll(nestedScrollConnection),
    ) { measurables, constraints ->
        val toolbarConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        val bodyConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
            maxHeight = constraints.maxHeight,
        )

        val toolbarPlaceable = measurables[0].measure(toolbarConstraints)

        val bodyMeasurables = measurables.subList(1, measurables.size)
        val bodyPlaceables = bodyMeasurables.map { it.measure(bodyConstraints) }

        val toolbarHeight = toolbarPlaceable.height

        val width = max(toolbarPlaceable.width, bodyPlaceables.maxOfOrNull { it.width } ?: 0).coerceIn(
            constraints.minWidth,
            constraints.maxWidth,
        )
        val height = max(toolbarHeight, bodyPlaceables.maxOfOrNull { it.height } ?: 0).coerceIn(
            constraints.minHeight,
            constraints.maxHeight,
        )

        layout(width, height) {
            bodyPlaceables.forEach { placeable ->
                placeable.placeRelative(0, toolbarHeight + state.offsetY.value)
            }
            toolbarPlaceable.placeRelative(0, state.offsetY.value)
        }
    }
}

@Stable
class CollapsingToolbarScaffoldState {
    var expendedSizePx: Int by mutableStateOf(0)
    var collapsedSizePx: Int by mutableStateOf(0)

    val offsetY: MutableState<Int> = mutableStateOf(0)

    val progress: State<Float> = derivedStateOf {
        offsetY.value.absoluteValue.toFloat() / (expendedSizePx - collapsedSizePx).toFloat()
    }
}
