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

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

@Stable
class CollapsingToolbarState(
    val collapsedHeightPx: Int,
    val expendedHeightPx: Int,
) : ScrollableState {

    var height: Int by mutableStateOf(Int.MAX_VALUE)
        private set

    var minHeight: Int
        get() = minHeightState
        internal set(value) {
            minHeightState = value

            if (height < value) {
                height = value
            }
        }
    var maxHeight: Int
        get() = maxHeightState
        internal set(value) {
            maxHeightState = value

            if (value < height) {
                height = value
            }
        }

    private var maxHeightState by mutableStateOf(Int.MAX_VALUE)
    private var minHeightState by mutableStateOf(0)

    private val scrollableState = ScrollableState { value ->
        val consume = if (value < 0) {
            max(minHeight.toFloat() - height, value)
        } else {
            min(maxHeight.toFloat() - height, value)
        }

        val current = consume + deferredConsumption
        val currentInt = current.toInt()

        if (current.absoluteValue > 0) {
            height += currentInt
            deferredConsumption = current - currentInt
        }

        consume
    }

    private var deferredConsumption: Float = 0f

    /**
     * @return Remaining velocity after fling
     */
    suspend fun fling(flingBehavior: FlingBehavior, velocity: Float): Float {
        var left = velocity
        scroll {
            with(flingBehavior) {
                left = performFling(left)
            }
        }

        return left
    }

    override val isScrollInProgress: Boolean
        get() = scrollableState.isScrollInProgress

    override fun dispatchRawDelta(delta: Float): Float = scrollableState.dispatchRawDelta(delta)

    override suspend fun scroll(
        scrollPriority: MutatePriority,
        block: suspend ScrollScope.() -> Unit,
    ): Unit = scrollableState.scroll(scrollPriority, block)
}

@Composable
fun rememberCollapsingToolbarState(
    collapsedHeightPx: Int,
    expendedHeightPx: Int,
): CollapsingToolbarState {
    return remember(collapsedHeightPx, expendedHeightPx) {
        CollapsingToolbarState(
            collapsedHeightPx = collapsedHeightPx,
            expendedHeightPx = expendedHeightPx,
        )
    }
}

@Composable
fun CollapsingToolbar(
    modifier: Modifier = Modifier,
    collapsingToolbarState: CollapsingToolbarState,
    content: @Composable () -> Unit,
) {
    val measurePolicy = remember(collapsingToolbarState) {
        CollapsingToolbarMeasurePolicy(collapsingToolbarState)
    }

    Layout(
        content = content,
        measurePolicy = measurePolicy,
        modifier = modifier.clipToBounds(),
    )
}

private class CollapsingToolbarMeasurePolicy(
    private val collapsingToolbarState: CollapsingToolbarState,
) : MeasurePolicy {
    override fun MeasureScope.measure(
        measurables: List<Measurable>,
        constraints: Constraints,
    ): MeasureResult {
        val placeables = measurables.map {
            it.measure(
                constraints.copy(
                    minWidth = 0,
                    minHeight = 0,
                    maxHeight = Constraints.Infinity,
                ),
            )
        }

        val minHeight = placeables.minOfOrNull { it.height }
            ?.coerceIn(constraints.minHeight, constraints.maxHeight) ?: 0

        val maxHeight = placeables.maxOfOrNull { it.height }
            ?.coerceIn(constraints.minHeight, constraints.maxHeight) ?: 0

        val maxWidth = placeables.maxOfOrNull { it.width }
            ?.coerceIn(constraints.minWidth, constraints.maxWidth) ?: 0

        collapsingToolbarState.also {
            it.minHeight = minHeight
            it.maxHeight = maxHeight
        }

        val height = collapsingToolbarState.height
        return layout(maxWidth, height) {
            placeables.forEach { placeable ->
                placeable.placeRelative(0, 0)
            }
        }
    }
}
