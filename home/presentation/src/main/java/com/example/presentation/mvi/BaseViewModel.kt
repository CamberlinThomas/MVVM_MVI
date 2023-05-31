package com.example.presentation.mvi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T>(private val initialState: T) : ViewModel() {

    private val _stateLivedata = MutableLiveData(initialState)

    val stateLivedata: LiveData<T>
        get() = _stateLivedata


    fun updateState(modifier: (T) -> T) {
        val currentState = _stateLivedata.value ?: initialState
        _stateLivedata.value = modifier(currentState)
    }


}