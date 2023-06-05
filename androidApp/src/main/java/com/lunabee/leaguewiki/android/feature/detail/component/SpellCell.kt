package com.lunabee.leaguewiki.android.feature.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.lunabee.leaguewiki.SharedConstants
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

@Composable
fun SpellCell(
    onClick: () -> Unit,
    name: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(LeagueWikiTheme.radius.small))
            .clickable(onClick = onClick)
            .background(LeagueWikiTheme.colors.backgroundSecondary)
            .padding(LeagueWikiTheme.spacing.large)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(SharedConstants.DetailDimens.SpellImageSize.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = name,
            color = LeagueWikiTheme.colors.contentPrimary,
            style = LeagueWikiTheme.typography.textLarge,
            modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
        )
    }
}