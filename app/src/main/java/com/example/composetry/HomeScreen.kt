package com.example.composetry

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
        if (checked1){
            val counter by produceState(initialValue = 0) {
                awaitDispose {

                }
            }
            Text(text = "count - $counter")
        }
        if (checked2){
            var sliderPosition by remember { mutableStateOf(1f) }
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..10f
            )
            TrackPostition(position = sliderPosition)
        }
    }
}

@Composable
fun TrackPostition(position: Float) {
//    val postitionState = remember {
//        mutableStateOf(position)
//    }
//    postitionState.value = position

    val positionState = rememberUpdatedState(position)
    LaunchedEffect(true) {
        while (true){
            delay(1000)
            Log.d("TAG", "TrackPostition: ${positionState.value}")
        }
    }
}



