package com.example.composetry

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.composetry.ui.theme.ComposeTryTheme

data class MyTextStyle(
    val color: Color = Color.Unspecified,
    val fontSize: TextUnit = 12.sp,
    val align: TextAlign = TextAlign.Left
)

val LocalFontStyle = compositionLocalOf { MyTextStyle() }
val TAG = "HomeScreen"

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

        Button(onClick = {}) {
            Text("fasdfdf")
        }

        Log.d(TAG, "HomeScreen ${italicState.value}")
        val color = if (italicState.value) Color.Gray else Color.Green
        CompositionLocalProvider(LocalFontStyle provides MyTextStyle(color)) {
            MyText(text = "Text 1")
            Test()
        }
    }
}

@Composable
fun MyCheckbox(text: String, checked: MutableState<Boolean>) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked.value, onCheckedChange = { checked.value = it })
        Text(text = text)
    }
}

@Composable
fun Test() {
    Log.d(TAG, "Test")
    Text(text = "Test")
}

@Composable
fun MyText(text: String) {
    Log.d(TAG, "MyText")
    Text(text = text, color = LocalFontStyle.current.color)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    ComposeTryTheme {
        HomeScreen()
    }
}



