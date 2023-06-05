package com.lunabee.leaguewiki.android.feature.detail.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

@Composable
fun NavigationIconButton(
    onNavigateBack: () -> Unit,
) {
    IconButton(
        onClick = onNavigateBack,
        modifier = Modifier
            .statusBarsPadding()
            .padding(start = LeagueWikiTheme.spacing.xSmall, top = LeagueWikiTheme.spacing.xSmall)
            .zIndex(1.0f),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = LeagueWikiTheme.colors.contentOnPrimary,
            modifier = Modifier.size(24.dp),
        )
    }
}
