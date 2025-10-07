package com.example.composetry

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserListScreen(
    onUserClick: () -> Unit,
    usersSharedViewModel: UsersSharedViewModel = viewModel()
) {
    Column {
        Text(text = "Users screen")
        Text(
            text = "User 1",
            modifier = Modifier.clickable(onClick = onUserClick)
        )
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun UserScreen(
    usersSharedViewModel: UsersSharedViewModel = viewModel()
) {
    Text(text = "User")
    Log.d("TAG","viewModel ${usersSharedViewModel.hashCode().toHexString()}")
}



