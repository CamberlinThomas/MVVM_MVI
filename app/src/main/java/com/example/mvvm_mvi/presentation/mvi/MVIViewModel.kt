package com.example.mvvm_mvi.presentation.mvi

import com.example.mvvm_mvi.domain.GetAgeUseCase
import com.example.mvvm_mvi.domain.GetNameUseCase

class MVIViewModel : BaseViewModel<ScreenState>(ScreenState()) {


    fun handle(action:Action){
        when(action){
            Action.GetInfo -> getInfo()
        }
    }


    private fun getInfo() {
        getName()
        getAge()
    }

    private fun getName() {
        GetNameUseCase().execute()
            .run { updateState { it.copy( name=this.getOrNull())  }}
    }

    private fun getAge() {
        GetAgeUseCase().execute()
            .run { updateState { it.copy( age=this.getOrNull()) }}
    }

}