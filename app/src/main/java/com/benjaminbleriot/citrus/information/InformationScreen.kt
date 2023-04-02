package com.benjaminbleriot.citrus.information

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.benjaminbleriot.citrus.navigation.Screen
import com.benjaminbleriot.citrus.ui.theme.CitrusTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun InformationScreen(navController: NavHostController) {
    val context = LocalContext.current
    val onNavigateToScannerScreen: () -> Unit = {
        navController.navigate(Screen.BottomNavBar.Scanner.route)
    }

    val cameraPermissionState =
        rememberPermissionState(permission = Manifest.permission.CAMERA) { isGranted ->
            if (isGranted) {
                Toast.makeText(context, "permission granted", Toast.LENGTH_SHORT).show()
                onNavigateToScannerScreen()
            } else {
                Toast.makeText(context, "permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        LaunchedEffect(Unit) {
            onNavigateToScannerScreen()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Merci d'avoir téléchargé cette application.\n Afin de pourvoir l'utiliser, vous devez autoriser l'accès à la camera.",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                Text(text = "Autoriser la caméra")
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun InformationScreenPreview() {
    CitrusTheme {
        InformationScreen(navController = rememberNavController())
    }
}