package com.example.mvvm_mvi.presentation.mvi

data class ScreenState(
    val age: Int? = null,
    val name: String? = null
) {
    val errorMessage: Boolean = age == null || name == null
}
