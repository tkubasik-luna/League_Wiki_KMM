package com.lunabee.leaguewiki.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.model.ChampionInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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
    val championInfo by viewModel.championInfo.collectAsState(initial = listOf())
    Text(text = championInfo.toString())
}

class TestViewModel(
    private val championRepository: ChampionRepository,
) : ViewModel() {

    val championInfo: Flow<List<ChampionInfo>> = flow {
        emit(championRepository.getChampionList())
    }
}