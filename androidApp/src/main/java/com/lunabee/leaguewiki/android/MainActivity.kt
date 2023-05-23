package com.lunabee.leaguewiki.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.model.Champion
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    GreetingView()
                }
            }
        }
    }
}

@Composable
fun GreetingView(
    viewModel: TestViewModel = koinViewModel(),
) {
    Text(text = viewModel.list.toString())
}

class TestViewModel(
    championRepository: ChampionRepository,
) : ViewModel() {
    val list: List<Champion> = championRepository.getChampionsInfo()
}