package com.example.composetry

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview

val LocalFontStyle = compositionLocalOf { FontStyle.Normal }
@Composable
fun HomeScreen(
) {
    Column(modifier = Modifier.statusBarsPadding()) {
        var checked1 by remember { mutableStateOf(false) }
        var checked2 by remember { mutableStateOf(false) }
        var checked3 by remember { mutableStateOf(false) }
        val italicState = remember { mutableStateOf(false) }
        Checkbox(checked = checked1, onCheckedChange = { checked1 = it })
        Checkbox(checked = checked2, onCheckedChange = { checked2 = it })
        Checkbox(checked = checked3, onCheckedChange = { checked3 = it })
        MyCheckbox("Italic", italicState)

        val fontStyle = if (italicState.value) FontStyle.Italic else FontStyle.Normal
        CompositionLocalProvider(LocalFontStyle provides fontStyle) {
            MyText(text = "Text 1")
            MyText(text = "Text 2")
            MyText(text = "Text 3")
            MyText(text = "Text 4")
        }
        MyText(text = "Text 5")
    }
}

@Composable
fun MyCheckbox(text: String, checked: MutableState<Boolean>) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked.value, onCheckedChange = {checked.value = it})
        Text(text = text)
    }
}

@Composable
fun MyText(text: String) {
    Text(text = text, fontStyle = LocalFontStyle.current)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}



