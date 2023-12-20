package com.example.bookmanagemant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.bookmanagemant.ViewModels.ApiVM
import com.example.bookmanagemant.ViewModels.AppVM
import com.example.bookmanagemant.screen.MainScreen
import com.example.bookmanagemant.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize the ViewModel
        val apiVM = ApiVM()
        val appVM = AppVM()

        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(apiVM, appVM)
                }
            }
        }
    }
}

