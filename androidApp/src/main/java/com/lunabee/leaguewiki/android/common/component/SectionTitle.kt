package com.lunabee.leaguewiki.android.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    title: String,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = LeagueWikiTheme.typography.textLarge,
            color = LeagueWikiTheme.colors.contentPrimary
        )
        Spacer(modifier = Modifier.height(LeagueWikiTheme.spacing.xSmall))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(LeagueWikiTheme.spacing.verySmall)
                .clip(CircleShape)
                .background(LeagueWikiTheme.colors.secondary)
        )
    }
}