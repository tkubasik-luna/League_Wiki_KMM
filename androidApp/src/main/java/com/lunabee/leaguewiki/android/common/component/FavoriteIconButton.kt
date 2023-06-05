package com.lunabee.leaguewiki.android.common.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.lunabee.leaguewiki.android.R
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

@Composable
fun FavoriteIconButton(
    onFavClick: () -> Unit,
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onFavClick,
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(id = if (isFavorite) R.drawable.ic_filled_heart else R.drawable.ic_empty_heart),
            contentDescription = null,
            tint = LeagueWikiTheme.colors.secondary
        )
    }
}