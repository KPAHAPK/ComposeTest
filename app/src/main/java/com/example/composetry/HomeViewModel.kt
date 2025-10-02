package com.example.composetry

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private val _counter = mutableStateOf(0)
    val counter =  _counter.asIntState()


    fun increase(){
        _counter.value++
    }
}