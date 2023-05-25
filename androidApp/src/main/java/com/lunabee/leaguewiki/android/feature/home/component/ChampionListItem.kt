package com.lunabee.leaguewiki.android.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.lunabee.leaguewiki.android.R
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import com.lunabee.leaguewiki.feature.SharedConstants
import com.lunabee.leaguewiki.feature.home.UiChampionInfo

@Composable
fun ChampionListItem(
    onFavClick: () -> Unit,
    modifier: Modifier = Modifier,
    championInfo: UiChampionInfo,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(LeagueWikiTheme.radius.small))
            .background(LeagueWikiTheme.colors.backgroundSecondary)
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
                    text = championInfo.title.orEmpty(),
                    style = LeagueWikiTheme.typography.textLarge,
                    color = LeagueWikiTheme.colors.contentPrimary
                )
                Text(
                    text = championInfo.name.orEmpty(),
                    style = LeagueWikiTheme.typography.textBase,
                    color = LeagueWikiTheme.colors.contentPrimary
                )
            }
        }
        IconButton(
            onClick = onFavClick,
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(
                painter = painterResource(id = if (championInfo.isFavorite) R.drawable.ic_filled_heart else R.drawable.ic_empty_heart),
                contentDescription = null,
                tint = LeagueWikiTheme.colors.secondary
            )
        }
    }
}