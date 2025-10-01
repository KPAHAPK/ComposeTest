package com.example.composetry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val count = mutableIntStateOf(0)
        val checked = mutableStateOf(false)
        val text = mutableStateOf("false")
        setContent {
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
    }
}