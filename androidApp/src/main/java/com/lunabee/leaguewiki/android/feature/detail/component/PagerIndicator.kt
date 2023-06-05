package com.lunabee.leaguewiki.android.feature.detail.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pageCount: Int,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(LeagueWikiTheme.spacing.small, Alignment.CenterHorizontally)
    ) {
        repeat(pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) {
                LeagueWikiTheme.colors.secondary
            } else {
                LeagueWikiTheme.colors.primary
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)

            )
        }
    }
}