package com.lunabee.leaguewiki.android.feature.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.lunabee.leaguewiki.android.common.component.FavoriteIconButton
import com.lunabee.leaguewiki.android.common.component.SectionTitle
import com.lunabee.leaguewiki.android.common.component.collapsingtoolbar.CollapsingToolbarScaffold
import com.lunabee.leaguewiki.android.common.component.collapsingtoolbar.CollapsingToolbarScaffoldState
import com.lunabee.leaguewiki.android.feature.detail.component.DetailTopBar
import com.lunabee.leaguewiki.android.feature.detail.component.NavigationIconButton
import com.lunabee.leaguewiki.android.feature.detail.component.PagerIndicator
import com.lunabee.leaguewiki.android.feature.detail.component.SkinCell
import com.lunabee.leaguewiki.android.feature.detail.component.SpellCell
import com.lunabee.leaguewiki.android.feature.detail.component.TagCell
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import com.lunabee.leaguewiki.feature.detail.UiChampionDetail
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailRoute(
    navigateBack: () -> Unit,
    viewModel: DetailViewModel = koinViewModel(),
) {
    val championDetail by viewModel.championDetail.collectAsState(initial = null)
    championDetail?.let {
        DetailScreen(
            onBackClick = navigateBack,
            championDetail = it,
            onFavClick = viewModel::uiToggleFavorite
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
    championDetail: UiChampionDetail,
    onFavClick: () -> Unit,
) {
    val localDensity = LocalDensity.current
    val collapsingToolbarScaffoldState = remember { CollapsingToolbarScaffoldState() }
    val navigationBarHeightPx = WindowInsets.navigationBars.getBottom(LocalDensity.current)
    val spacerSizeDp = remember(collapsingToolbarScaffoldState.collapsedSizePx) {
        with(localDensity) { (collapsingToolbarScaffoldState.collapsedSizePx + navigationBarHeightPx).toDp() }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        NavigationIconButton(onNavigateBack = onBackClick)
        FavoriteIconButton(
            onFavClick = onFavClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .zIndex(1.0f)
                .statusBarsPadding()
                .padding(end = LeagueWikiTheme.spacing.xSmall, top = LeagueWikiTheme.spacing.xSmall),
            isFavorite = championDetail.isFavorite
        )
        CollapsingToolbarScaffold(
            state = collapsingToolbarScaffoldState,
            toolbar = {
                DetailTopBar(
                    collapsingToolbarState = collapsingToolbarScaffoldState,
                    imageUrl = championDetail.imageUrl,
                    championName = championDetail.name
                )
            },
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(),
            ) {
                // Tags
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(LeagueWikiTheme.spacing.medium),
                        modifier = Modifier.padding(LeagueWikiTheme.spacing.large)
                    ) {
                        championDetail.tags.forEach { TagCell(tag = it) }
                    }
                }
                // Lore
                item {
                    SectionTitle(
                        title = "Lore",
                        modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
                    )
                    Text(
                        text = championDetail.title,
                        color = LeagueWikiTheme.colors.contentPrimary,
                        style = LeagueWikiTheme.typography.textLarge,
                        modifier = Modifier
                            .padding(horizontal = LeagueWikiTheme.spacing.large)
                            .padding(top = LeagueWikiTheme.spacing.large, bottom = LeagueWikiTheme.spacing.small)
                    )
                    Text(
                        text = championDetail.lore,
                        color = LeagueWikiTheme.colors.contentSecondary,
                        style = LeagueWikiTheme.typography.textBase,
                        modifier = Modifier
                            .padding(horizontal = LeagueWikiTheme.spacing.large)
                            .padding(bottom = LeagueWikiTheme.spacing.large)
                    )
                }
                // Passive
                item {
                    SectionTitle(
                        title = "Passive",
                        modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
                    )
                    SpellCell(
                        onClick = { /*TODO*/ },
                        name = championDetail.passive.name,
                        imageUrl = championDetail.passive.imageUrl,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(LeagueWikiTheme.spacing.large)
                    )
                }
                // Spells
                item {
                    SectionTitle(
                        title = "Spells",
                        modifier = Modifier
                            .padding(horizontal = LeagueWikiTheme.spacing.large)
                            .padding(bottom = LeagueWikiTheme.spacing.large)
                    )
                    championDetail.spells.forEach {
                        SpellCell(
                            onClick = { /*TODO*/ },
                            name = it.name,
                            imageUrl = it.imageUrl,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = LeagueWikiTheme.spacing.large)
                                .padding(bottom = LeagueWikiTheme.spacing.large)
                        )
                    }
                }
                // Skins
                item {
                    SectionTitle(
                        title = "Skins",
                        modifier = Modifier
                            .padding(horizontal = LeagueWikiTheme.spacing.large)
                    )
                    val pagerState = rememberPagerState()
                    HorizontalPager(
                        pageCount = championDetail.skins.size,
                        state = pagerState,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SkinCell(
                            skin = championDetail.skins[it],
                            modifier = Modifier
                                .width(LocalConfiguration.current.screenWidthDp.dp)
                                .padding(LeagueWikiTheme.spacing.large)
                        )
                    }
                    PagerIndicator(
                        pagerState = pagerState,
                        pageCount = championDetail.skins.size,
                        modifier = Modifier.padding(horizontal = LeagueWikiTheme.spacing.large)
                    )
                }
                item {
                    Spacer(Modifier.height(spacerSizeDp))
                }
            }
        }
    }
}