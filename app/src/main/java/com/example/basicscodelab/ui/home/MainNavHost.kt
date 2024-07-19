package com.example.basicscodelab.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * Description:
 * Author: Vincent
 * Date: 2024/7/19
 * Email:vincent.wei@backgardon.com
 * Version:
 */
@Composable
fun MainNavHost(
  navController: NavHostController,
  modifier: Modifier = Modifier
) {
  NavHost(
    navController = navController,
    startDestination = Home.route,
    modifier = modifier
  ){
    composable(Home.route){
      Anniversary()
    }
    composable(Mood.route){
      MoodScreen()
    }
    composable(Setting.route){
      SettingScreen()
    }
  }
}

fun NavHostController.navigateSingleTopTo(route: String) =
  this.navigate(route) {
    // Pop up to the start destination of the graph to
    // avoid building up a large stack of destinations
    // on the back stack as users select items
    popUpTo(
      this@navigateSingleTopTo.graph.findStartDestination().id
    ) {
      saveState = true
    }
    // Avoid multiple copies of the same destination when
    // reselecting the same item
    launchSingleTop = true
    // Restore state when reselecting a previously selected item
    restoreState = true
  }