package com.lunabee.leaguewiki.android.feature.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.lunabee.leaguewiki.SharedConstants
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import com.lunabee.leaguewiki.feature.detail.UiSkin
import java.util.Locale

@Composable
fun SkinCell(
    modifier: Modifier = Modifier,
    skin: UiSkin,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(LeagueWikiTheme.radius.small))
            .background(LeagueWikiTheme.colors.primary)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = skin.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(SharedConstants.DetailDimens.SkinImageAspectRatio)
        )
        Text(
            text = skin.name.capitalize(Locale.ROOT),
            color = LeagueWikiTheme.colors.contentOnPrimary,
            style = LeagueWikiTheme.typography.textLarge,
            modifier = Modifier.padding(LeagueWikiTheme.spacing.large)
        )
    }
}