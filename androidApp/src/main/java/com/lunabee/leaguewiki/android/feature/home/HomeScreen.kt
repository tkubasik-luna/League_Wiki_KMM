package com.lunabee.leaguewiki.android.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = koinViewModel(),
) {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(LeagueWikiTheme.colors.primary)
                .statusBarsPadding()
                .padding(LeagueWikiTheme.spacing.large)
        ) {
            Text(
                text = "LeagueWiki",
                style = LeagueWikiTheme.typography.text2Xl,
                color = LeagueWikiTheme.colors.contentOnPrimary
            )
        }
    }
}