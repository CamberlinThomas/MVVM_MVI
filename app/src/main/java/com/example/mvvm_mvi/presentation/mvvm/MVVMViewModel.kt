package com.example.mvvm_mvi.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_mvi.domain.GetAgeUseCase
import com.example.mvvm_mvi.domain.GetNameUseCase

/**
 * not expose mutable
 */

class MVVMViewModel : ViewModel() {

    private val _nameLivedata = MutableLiveData<String?>()
    val nameLiveData: LiveData<String?>
        get() = _nameLivedata

    private val _ageLivedata = MutableLiveData<Int?>()
    val ageLivedata: LiveData<Int?>
        get() = _ageLivedata

    private val _errorLivedata = MediatorLiveData<Boolean>()
    val errorLivedata: LiveData<Boolean>
        get() = _errorLivedata

    init {
        _errorLivedata.addSource(_nameLivedata) {setErrorMessage()}
        _errorLivedata.addSource(_ageLivedata) {setErrorMessage()}
    }

    private fun setErrorMessage() {
        _errorLivedata.value = _ageLivedata.value == null || _nameLivedata.value == null
    }

    fun getInfo() {
        getName()
        getAge()
    }

    private fun getName() {
        GetNameUseCase().execute()
            .run { _nameLivedata.value = this.getOrNull() }
    }

    private fun getAge() {
        GetAgeUseCase().execute()
            .run { _ageLivedata.value = this.getOrNull() }
    }

}