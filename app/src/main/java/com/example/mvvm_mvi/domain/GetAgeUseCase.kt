package com.example.mvvm_mvi.domain

import android.accounts.NetworkErrorException
import kotlin.random.Random

class GetAgeUseCase {

    fun execute(): Result<Int> {

        val value = Random.nextInt(0, 5)

        return if (value < 2) {
            Result.failure(NetworkErrorException("Impossible to get value"))
        } else {
            Result.success(value)
        }

    }

}