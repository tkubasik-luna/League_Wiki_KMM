package com.lunabee.leaguewiki.android.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun ChampionListItem(
    onFavClick: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    championInfo: UiChampionInfo,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(LeagueWikiTheme.radius.small))
            .background(LeagueWikiTheme.colors.backgroundSecondary)
            .clickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(LeagueWikiTheme.spacing.medium)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = championInfo.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(SharedConstants.HomeDimens.ChampionImageSize.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(LeagueWikiTheme.spacing.large))
            Column {
                Text(
                    text = championInfo.name.orEmpty(),
                    style = LeagueWikiTheme.typography.textLarge,
                    color = LeagueWikiTheme.colors.contentPrimary
                )
                Text(
                    text = championInfo.title.orEmpty(),
                    style = LeagueWikiTheme.typography.textBase,
                    color = LeagueWikiTheme.colors.contentSecondary
                )
            }
        }

        FavoriteIconButton(
            onFavClick = onFavClick,
            modifier = Modifier.align(Alignment.TopEnd),
            isFavorite = championInfo.isFavorite
        )
    }
}