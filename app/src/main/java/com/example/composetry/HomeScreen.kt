package com.example.composetry

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
) {
    Column {
        Text(text = "Home screen")
    }
}

@Composable
fun OrdersScreen() {
    Text(text = "Order Screen")
}

@Composable
fun UsersScreen(
    onUserClick: (String) -> Unit
) {
    Text(
        text = "User Screen",
        modifier = Modifier.clickable { onUserClick("asdfas") })
}

@Composable
fun UserScreen(
    id: String = ""
) {
    Text(text = id)
}





