package com.lunabee.leaguewiki.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lunabee.leaguewiki.android.common.MainNavGraph
import com.lunabee.leaguewiki.android.theme.LeagueWikiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeagueWikiTheme {
                MainNavGraph()
            }
        }
    }
}