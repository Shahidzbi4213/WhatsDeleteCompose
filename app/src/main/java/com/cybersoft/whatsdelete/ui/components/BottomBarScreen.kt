package com.cybersoft.whatsdelete.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


// Created by Shahid Iqbal on 1/10/2023.

sealed class BottomBarScreen(
    val route: String,
    val label: String,
    val icon: ImageVector
) {

    object Home : BottomBarScreen(
        route = "home",
        label = "Home",
        icon = Icons.Default.Home
    )

    object Setting : BottomBarScreen(
        route = "setting",
        label = "Setting",
        icon = Icons.Default.Settings
    )
}