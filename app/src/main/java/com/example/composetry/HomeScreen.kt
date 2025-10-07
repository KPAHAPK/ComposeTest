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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
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
        if (checked1) {
            LaunchedEffect(key1 = Unit) {
                var count = 0
                while (true) {
                    Log.d("HomeScreen", "count = ${count++}")
                    delay(1000)
                }
            }
        }
        val context = LocalContext.current
        Checkbox(checked = checked2, onCheckedChange = { checked2 = it })
        if (checked2) {
            DisposableEffect(key1 = Unit) {
                val broadcastReceiver = object : BroadcastReceiver() {
                    override fun onReceive(
                        p0: Context,
                        p1: Intent?
                    ) {
                        Log.d("HomeScreen", "onReceive")
                    }
                }
                ContextCompat.registerReceiver(
                    context,
                    broadcastReceiver,
                    IntentFilter("com.dfo.weof.sdf"),
                    ContextCompat.RECEIVER_EXPORTED
                )
                onDispose {
                    context.unregisterReceiver(broadcastReceiver)
                }
            }
        }

        Button(onClick = { context.sendBroadcast(Intent("com.dfo.weof.sdf")) }) {
            Text(text = "send broadcast")
        }
        val scope = rememberCoroutineScope()
        Checkbox(checked = checked3, onCheckedChange = { checked3 = it })
        if (checked3) {
            Button(onClick = {
                scope.launch {
                    var count = 0
                    while (true) {
                        Log.d("HomeScreen", "count = ${count++}")
                        delay(1000)
                    }
                }
            }) {
                Text(text = "launch coroutine")
            }
        }
    }
}



