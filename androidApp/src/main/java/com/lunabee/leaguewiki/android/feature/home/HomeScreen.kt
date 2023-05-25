package com.lunabee.leaguewiki.android.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.lunabee.leaguewiki.android.feature.home.component.ChampionListItem
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import com.lunabee.leaguewiki.feature.home.UiChampionInfo
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val championList by viewModel.championsList.collectAsState(initial = listOf())
    HomeScreen(championList)
}

@Composable
fun HomeScreen(
    championList: List<UiChampionInfo>,
) {
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
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(LeagueWikiTheme.spacing.medium),
            contentPadding = PaddingValues(vertical = LeagueWikiTheme.spacing.large)
        ) {
            items(championList) {
                ChampionListItem(
                    onFavClick = { /*TODO*/ },
                    championInfo = it,
                    modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
                )
            }
        }
    }
}