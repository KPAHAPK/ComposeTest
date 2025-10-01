package com.example.composetry

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
    val counterValue = click.value
    var checked by remember { mutableStateOf(false)}
    Log.d("TAG", "checkedValue: $checked")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        ClickCounter(counterValue, onCounterClick, checkedValue)
        Row(modifier = Modifier.clickable(onClick = { checked = !checked })) {
            Checkbox(checked = checked, onCheckedChange = { checked = !checked })
            Text("More details", fontSize = 18.sp)
        }
        if (checked){
            Text(text = "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
        }
    }

}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun ClickCounter(counterValue: Int, onCounterClick: () -> Unit, upperCase: Boolean) {
    val evenOdd = remember(upperCase) { EvenOdd(upperCase = upperCase) }
    Text(
        text = "Clicks: $counterValue ${evenOdd.check(counterValue)}",
        modifier = Modifier
            .clickable(onClick = onCounterClick)
    )
    Log.d("TAG", "ClickCounter(counter = $counterValue, uppercase = $upperCase), $evenOdd")
}

@Preview
@Composable
fun HomeScreenPreview() {
    val count = mutableStateOf(0)
    val checked = mutableStateOf(false)
    val text = mutableStateOf("false")
    HomeScreen(
        count,
        { count.value++ },
        checked,
        {
            println(it)
            checked.value = !checked.value
            if (checked.value) {
                count.value++
            }
        }, text,
        { newText -> text.value = newText })
}
