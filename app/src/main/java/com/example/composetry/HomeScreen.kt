package com.example.composetry

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    click: State<Int>,
    onCounterClick: () -> Unit,
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit,
    text: State<String>,
    onTextChange: (String) -> Unit
) {
    val list = remember {
        List(20){"Item $it"}.toMutableList()
    }
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        TextButton(onClick = {
            Log.d("TAG", "----append----")
            list.add("Item${list.size + 1}")

        }) { Text(text = "Append") }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .border(width = 1.dp, color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(list) { item ->
                key(item){
                    SomeItem(item)
                }
            }
        }

    }

}

@Composable
fun SomeItem(text: String) {
    Log.d("TAG", "SomeItem: $text")
    Text(
        text = text,
        fontSize = 18.sp,
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp)
    )
}



