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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.lunabee.leaguewiki.android.common.component.SectionTitle
import com.lunabee.leaguewiki.android.feature.home.component.ChampionFavoriteCell
import com.lunabee.leaguewiki.android.feature.home.component.ChampionListItem
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import com.lunabee.leaguewiki.feature.home.UiChampionInfo

@Composable
fun HomeRoute(
    navigateToChampionDetail: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val championList by viewModel.championList.collectAsState(initial = listOf())
    HomeScreen(
        championList = championList,
        onFavoriteClick = { viewModel.uiToggleFavorite(it) },
        onChampionClick = navigateToChampionDetail
    )
}

@Composable
fun HomeScreen(
    championList: List<UiChampionInfo>,
    onFavoriteClick: (String) -> Unit,
    onChampionClick: (String) -> Unit,
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
            if (championList.any { it.isFavorite }) {
                item {
                    SectionTitle(
                        title = "Favorites",
                        modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
                    )
                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = LeagueWikiTheme.spacing.large),
                        horizontalArrangement = Arrangement.spacedBy(LeagueWikiTheme.spacing.medium)
                    ) {
                        items(championList.filter { it.isFavorite }) {
                            ChampionFavoriteCell(
                                onClick = { onChampionClick(it.id) },
                                onFavClick = { onFavoriteClick(it.id) },
                                championInfo = it,
                                modifier = Modifier.fillMaxWidth(0.33f)
                            )
                        }
                    }
                }
                item {
                    SectionTitle(
                        title = "Tous",
                        modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
                    )
                }
            }
            items(championList) {
                ChampionListItem(
                    onClick = { onChampionClick(it.id) },
                    onFavClick = { onFavoriteClick(it.id) },
                    championInfo = it,
                    modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
                )
            }
        }
    }
}