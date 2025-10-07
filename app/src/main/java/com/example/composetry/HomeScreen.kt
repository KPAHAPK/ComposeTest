package com.example.composetry

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.compose
import kotlin.math.roundToInt

@Composable
fun HomeScreen(
) {
    Column(modifier = Modifier.statusBarsPadding()) {
        var checked1 by remember { mutableStateOf(false) }
        var checked2 by remember { mutableStateOf(false) }
        var checked3 by remember { mutableStateOf(false) }
        Checkbox(checked = checked1, onCheckedChange = { checked1 = it })
        Checkbox(checked = checked2, onCheckedChange = { checked2 = it })
        Checkbox(checked = checked3, onCheckedChange = { checked3 = it })
        if (checked1) {
            val sliderPosition = remember { mutableStateOf(1f) }
            MySlider(sliderPosition)
            val roundedPosition = remember { derivedStateOf { sliderPosition.value.roundToInt() } }
            Text(text = "position ${roundedPosition}")
            Log.d("TAG", "HomeScreen: ${roundedPosition.value}")
        }
        if (checked2) {
            val sliderPosition = remember { mutableStateOf(1f) }
            Slider(
                value = sliderPosition.value,
                onValueChange = { sliderPosition.value = it },
                valueRange = 0f..10f
            )
            TrackPostition(sliderPosition)
        }
    }
}

@Composable
fun MySlider(sliderPosition: MutableState<Float>) {
    Slider(
        value = sliderPosition.value,
        onValueChange = { sliderPosition.value = it },
        valueRange = 0f..10f
    )
}

@Composable
fun TrackPostition(position: State<Float>) {
    LaunchedEffect(true) {
        val flow = snapshotFlow{position.value}
        flow.collect {
            Log.d("TAG", "TrackPostition: ${it}")

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}



