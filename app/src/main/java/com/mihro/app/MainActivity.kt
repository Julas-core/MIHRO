package com.mihro.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.mihro.app.ui.MihroViewModel
import com.mihro.app.ui.theme.MihroTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MihroViewModel> {
        MihroViewModel.provideFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MihroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MihroApp(viewModel = viewModel)
                }
            }
        }
    }
}
