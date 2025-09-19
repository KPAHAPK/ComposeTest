package com.example.composetry

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    click: State<Int>,
    onCounterClick: () -> Unit,
) {
    val counterValue = click.value
    Log.d("TEST", "RRRRR")
    Row(
        modifier = Modifier.clickable(onClick = onCounterClick)) {
        Text(
            "sdf",
            fontSize = 99.sp,
        )
        
        Text(
            "${counterValue}",
            fontSize = 99.sp
        )
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    val count = mutableStateOf(0)
    HomeScreen(count) {
        count.value++
    }
}
