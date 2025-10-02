package com.example.composetry

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val counter by viewModel.counter
    ClickCounter(counter, onCounterClick = viewModel::increase)
}

@Composable
private fun ClickCounter(
    counter: Int,
    onCounterClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Clicks: $counter",
            modifier = Modifier.clickable(onClick = { onCounterClick() })
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClickCounterPreview() {
    var counter by remember { mutableStateOf(5) }
    ClickCounter(
        counter = counter,
        onCounterClick = {counter++}
    )
}



