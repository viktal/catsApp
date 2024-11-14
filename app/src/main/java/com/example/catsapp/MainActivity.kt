package com.example.catsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cats.ui.view.CatsMainScreen
import com.example.cats.ui.viewModel.CatsMainViewModel
import com.example.catsapp.ui.theme.CatsAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            CatsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val factory = (application as CatsApplication).catsViewModelFactory
                    val catsViewModel: CatsMainViewModel = viewModel(factory = factory)

                    CatsMainScreen(catsViewModel)
                }
            }
        }
    }
}
