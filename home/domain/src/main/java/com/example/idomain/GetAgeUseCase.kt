package com.example.idomain

class GetAgeUseCase(private val ageRepository:IAgeRepository) {

    fun execute(): Result<Int> {

        val value = ageRepository.getAge()

        return if (value < 2) {
            Result.failure(IllegalArgumentException("Impossible to get value"))
        } else {
            Result.success(value)
        }

    }

}