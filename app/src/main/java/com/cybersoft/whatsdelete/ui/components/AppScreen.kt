package com.cybersoft.whatsdelete.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.cybersoft.whatsdelete.data.viewmodels.NotificationViewModel
import kotlinx.coroutines.delay


// Created by Shahid Iqbal on 1/7/2023.

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(viewModel: NotificationViewModel, onDataLoad: () -> Unit) {

    LaunchedEffect(key1 = "key") {
        delay(2000)
        onDataLoad()
    }
    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomBar(navController) }, topBar = { TopBar(viewModel = viewModel) }) {

        BottomNavGraph(navController = navController, viewModel, Modifier.padding(it))
    }
}