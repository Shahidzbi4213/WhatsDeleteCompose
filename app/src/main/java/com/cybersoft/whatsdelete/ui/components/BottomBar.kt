package com.cybersoft.whatsdelete.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cybersoft.whatsdelete.data.viewmodels.NotificationViewModel


// Created by Shahid Iqbal on 1/7/2023.


@Composable
fun BottomNavGraph(
    navController: NavHostController,
    viewModel: NotificationViewModel,
    modifier: Modifier
) {


    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        modifier = modifier
    ) {

        composable(BottomBarScreen.Home.route) {
            HomeScreen()
            viewModel.title.value = "Home"
        }

        composable(BottomBarScreen.Setting.route) {
            SettingScreen()
            viewModel.title.value = "Setting"
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Setting,
    )
    BottomAppBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        screens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen, currentDestination: NavDestination?, navController: NavHostController
) {

    NavigationBarItem(
        icon = { Icon(imageVector = screen.icon, contentDescription = null) },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

        }
    )
}
