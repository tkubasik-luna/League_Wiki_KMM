package com.lunabee.leaguewiki.android.feature.detail

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import com.lunabee.leaguewiki.SharedConstants
import com.lunabee.leaguewiki.android.common.component.SectionTitle
import com.lunabee.leaguewiki.android.common.component.collapsingtoolbar.CollapsingToolbarScaffold
import com.lunabee.leaguewiki.android.common.component.collapsingtoolbar.CollapsingToolbarScaffoldState
import com.lunabee.leaguewiki.android.feature.detail.component.DetailTopBar

@Composable
fun DetailRoute(
    navigateBack: () -> Unit,
) {
    DetailScreen(
        onBackClick = navigateBack
    )
}

@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
) {
    val localDensity = LocalDensity.current
    val collapsingToolbarScaffoldState = remember { CollapsingToolbarScaffoldState() }
    val navigationBarHeightPx = WindowInsets.navigationBars.getBottom(LocalDensity.current)
    val spacerSizeDp = remember(collapsingToolbarScaffoldState.collapsedSizePx) {
        with(localDensity) { (collapsingToolbarScaffoldState.collapsedSizePx + navigationBarHeightPx).toDp() }
    }

    CollapsingToolbarScaffold(
        state = collapsingToolbarScaffoldState,
        toolbar = {
            DetailTopBar(
                collapsingToolbarState = collapsingToolbarScaffoldState,
                imageUrl = getSplashUrl("Jhin"),
                championName = "Jhin"
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
        ) {
            items(10) {
                SectionTitle(title = "Test")
            }
        }
    }
}

private fun getSplashUrl(id: String): String {
    return "${SharedConstants.Url.BASE_URL}cdn/img/champion/splash/${id}_1.jpg"
}