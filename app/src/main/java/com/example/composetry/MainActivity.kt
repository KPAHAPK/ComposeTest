package com.example.composetry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen() }
                    composable("orders") { OrdersScreen() }
                    composable("users") { UsersScreen(
                        onUserClick = {
                            navController.navigate("user/$it")
                        }
                    ) }
                    composable(
                        route = "user/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) {
                        val idString = it.arguments?.getString("id") ?: "null"
                        UserScreen(idString)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Home",
                        modifier = Modifier.clickable { navController.navigate("home") })
                    Text(
                        text = "Orders",
                        modifier = Modifier.clickable { navController.navigate("orders") })
                    Text(
                        text = "Users",
                        modifier = Modifier.clickable { navController.navigate("users") })
                }
            }
        }
    }
}
