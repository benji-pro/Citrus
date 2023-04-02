package com.benjaminbleriot.citrus.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.benjaminbleriot.citrus.history.HistoryScreen
import com.benjaminbleriot.citrus.information.InformationScreen
import com.benjaminbleriot.citrus.navigation.Screen.BottomNavBar.History
import com.benjaminbleriot.citrus.navigation.Screen.BottomNavBar.Scanner
import com.benjaminbleriot.citrus.navigation.Screen.BottomNavBar.Settings
import com.benjaminbleriot.citrus.navigation.Screen.Information
import com.benjaminbleriot.citrus.scanner.ScannerScreen
import com.benjaminbleriot.citrus.settings.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationComponent(navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Information.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Scanner.route) {
                ScannerScreen()
            }
            composable(Settings.route) {
                SettingsScreen()
            }
            composable(History.route) {
                HistoryScreen()
            }
            composable(Information.route) {
                InformationScreen(navController)
            }
        }
    }
}