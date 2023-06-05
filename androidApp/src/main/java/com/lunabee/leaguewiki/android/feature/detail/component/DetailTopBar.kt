package com.lunabee.leaguewiki.android.feature.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.lunabee.leaguewiki.android.common.component.collapsingtoolbar.CollapsingToolbarScaffoldState
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

@Composable
fun DetailTopBar(
    collapsingToolbarState: CollapsingToolbarScaffoldState,
    imageUrl: String,
    championName: String,
) {
    val spacerPx = with(LocalDensity.current) { 28.dp.toPx().toInt() }
    val statusBarHeightPx = WindowInsets.statusBars.getTop(LocalDensity.current)
    println(collapsingToolbarState.progress.value)
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Max)
        .background(LeagueWikiTheme.colors.primary)
        .onGloballyPositioned {
            if (collapsingToolbarState.expendedSizePx == 0) {
                collapsingToolbarState.expendedSizePx = it.size.height
            }
        }) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha = 1.0f - (collapsingToolbarState.progress.value)),
            contentScale = ContentScale.Crop,
        )
        BackgroundGradient(
            Modifier.fillMaxSize(),
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(
                text = championName,
                style = LeagueWikiTheme.typography.textXl,
                color = LeagueWikiTheme.colors.contentOnPrimary,
                modifier = Modifier
                    .padding(LeagueWikiTheme.spacing.large)
                    .onGloballyPositioned {
                        if (collapsingToolbarState.collapsedSizePx == 0) {
                            collapsingToolbarState.collapsedSizePx = it.size.height + statusBarHeightPx + spacerPx
                        }
                    }
                    .then(
                        if (!collapsingToolbarState.progress.value.isNaN()) {
                            Modifier.offset(x = 40.dp * collapsingToolbarState.progress.value)
                        } else {
                            Modifier
                        }
                    )

            )
        }
    }
}

@Composable
private fun BackgroundGradient(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        LeagueWikiTheme.colors.primary,
                        Color.Transparent,
                        Color.Transparent,
                        LeagueWikiTheme.colors.primary.copy(alpha = 0.3f),
                    ),
                ),
            ),
    )
}