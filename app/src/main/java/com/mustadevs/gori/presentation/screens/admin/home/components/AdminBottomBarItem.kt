package com.mustadevs.gori.presentation.screens.admin.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.wear.compose.material.ContentAlpha
import com.mustadevs.gori.presentation.navigation.screen.admin.AdminScreen


@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
    ){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor= LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(route = screen.route){
                popUpTo(navController.graph.findStartDestination().id)
            }
        }
        )
}