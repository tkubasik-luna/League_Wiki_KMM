package com.lunabee.leaguewiki.android.feature.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

@Composable
fun TagCell(
    tag: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = tag,
        color = LeagueWikiTheme.colors.contentOnPrimary,
        style = LeagueWikiTheme.typography.textBase,
        modifier = modifier
            .clip(CircleShape)
            .background(LeagueWikiTheme.colors.primary)
            .padding(
                vertical = LeagueWikiTheme.spacing.small,
                horizontal = LeagueWikiTheme.spacing.large
            )
    )
}