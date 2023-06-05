package com.lunabee.leaguewiki.android.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.lunabee.leaguewiki.SharedConstants
import com.lunabee.leaguewiki.android.common.component.FavoriteIconButton
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import com.lunabee.leaguewiki.feature.home.UiChampionInfo

@Composable
fun ChampionFavoriteCell(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onFavClick: () -> Unit,
    championInfo: UiChampionInfo,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(LeagueWikiTheme.radius.small))
            .background(LeagueWikiTheme.colors.backgroundSecondary)
            .clickable(onClick = onClick)
            .padding(LeagueWikiTheme.spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            Image(
                painter = rememberAsyncImagePainter(model = championInfo.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(SharedConstants.HomeDimens.ChampionImageSize.dp)
                    .clip(CircleShape)
            )
            FavoriteIconButton(
                onFavClick = onFavClick,
                isFavorite = championInfo.isFavorite,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = LeagueWikiTheme.spacing.large, y = LeagueWikiTheme.spacing.large)
            )
        }
        Spacer(modifier = Modifier.height(LeagueWikiTheme.spacing.medium))
        Text(
            text = championInfo.name.orEmpty(),
            style = LeagueWikiTheme.typography.textLarge,
            color = LeagueWikiTheme.colors.contentPrimary
        )
    }
}