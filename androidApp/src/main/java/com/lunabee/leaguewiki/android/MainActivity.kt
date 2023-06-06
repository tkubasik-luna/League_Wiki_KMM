package com.lunabee.leaguewiki.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lunabee.leaguewiki.android.common.MainNavGraph
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                isNavigationBarContrastEnforced = false,
                darkIcons = false,
            )

            LeagueWikiTheme {
                val backgroundColor = LeagueWikiTheme.colors.background
                Box(modifier = Modifier
                    .fillMaxSize()
                    .drawBehind { drawRect(color = backgroundColor) })
                MainNavGraph()
            }
        }
    }
}