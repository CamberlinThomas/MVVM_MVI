package com.example.presentation.mvi

import com.example.idomain.GetAgeUseCase
import com.example.idomain.GetNameUseCase


class MVIViewModel : BaseViewModel<ScreenState>(ScreenState()) {

    lateinit var getAgeUseCase:GetAgeUseCase





    fun handle(action: Action){
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
        getAgeUseCase.execute()
            .run { updateState { it.copy( age=this.getOrNull()) }}
    }

}