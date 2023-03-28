package com.benjaminbleriot.citrus.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
    sealed class BottomNavBar(val route: String, val icon: ImageVector, val title: String) {
        object Scanner : BottomNavBar("Scanner", Icons.Outlined.QrCodeScanner, "Scanner")
        object Settings : BottomNavBar("Settings", Icons.Outlined.Settings, "Settings")
        object History : BottomNavBar("History", Icons.Outlined.History, "History")
    }
}
