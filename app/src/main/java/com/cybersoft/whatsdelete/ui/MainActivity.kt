package com.cybersoft.whatsdelete.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.cybersoft.whatsdelete.data.viewmodels.NotificationViewModel
import com.cybersoft.whatsdelete.ui.components.MyApp
import com.cybersoft.whatsdelete.ui.theme.WhatsDeleteTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var flag = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            flag
        }
        setContent {
            WhatsDeleteTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel = hiltViewModel<NotificationViewModel>()
                    MyApp(viewModel) {
                        flag = false
                    }
                }
            }
        }
    }
}



