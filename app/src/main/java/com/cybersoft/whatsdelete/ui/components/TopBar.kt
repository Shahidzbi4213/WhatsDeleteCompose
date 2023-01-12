package com.cybersoft.whatsdelete.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.cybersoft.whatsdelete.data.viewmodels.NotificationViewModel


// Created by Shahid Iqbal on 1/12/2023.

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(viewModel: NotificationViewModel) {

    TopAppBar(title = { Text(text = viewModel.title.value) })
}