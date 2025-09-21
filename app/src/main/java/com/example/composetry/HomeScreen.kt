package com.example.composetry

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
    val checkedValue = checked.value
    val textValue = text.value
    Log.d("TEST", "RRRRR")
    Column {
        Row(
            modifier = Modifier.clickable(onClick = onCounterClick)
        ) {
            Text(
                "sdf",
                fontSize = 99.sp,
            )

            Text(
                "${counterValue}",
                fontSize = 99.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checkedValue, onCheckedChange = onCheckedChange)
            Text(
                textValue,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .clickable(onClick = {onCheckedChange(!checkedValue)})
            )
        }
        OutlinedTextField(
            textValue,
            onValueChange = onTextChange)
    }
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
        {newText -> text.value = newText })
}
