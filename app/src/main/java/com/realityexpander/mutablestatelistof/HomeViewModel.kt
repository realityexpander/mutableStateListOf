package com.realityexpander.mutablestatelistof

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    // Using a mutable state to hold the list of items, this will NOT recompose when the list changes.
    // This is because the MutableList is not the obervable, the MutableState is.
    private val _elements1: MutableState<MutableList<Int>> = mutableStateOf(mutableListOf())
    val elements1: State<List<Int>> = _elements1

    fun addElement() {
        val randomNumber = (0..100).random()
        _elements1.value.add(randomNumber)
        Log.d("HomeViewModel", "Added $randomNumber to elements")
    }


    // Using mutableStateListOf to hold the list of items, this will recompose when the list changes.
    private val _elements2 = mutableStateListOf<Int>()
    val elements2: List<Int> = _elements2

    fun addElement2() {
        val randomNumber = (0..100).random()
        _elements2.add(randomNumber)
        Log.d("HomeViewModel", "Added $randomNumber to elements2")
    }

}
