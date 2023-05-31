package com.example.idomain

import kotlin.random.Random

class GetNameUseCase {

    private val nameList = listOf(
        "Alice", "Maxime", "Clara", "Nicolas", "Emma",
        "Léo", "Julie", "Antoine", "Chloé", "Lucas",
        "Manon", "Alexandre", "Mélissa", "Théo", "Laura",
        "Julien", "Marie", "Hugo", "Sarah", "Paul",
        "Camille", "Romain", "Émilie", "Tom", "Caroline",
        "Mathieu", "Elise", "Louis", "Charlotte", "Gabriel"
    )

    fun execute(): Result<String> {

        val value = Random.nextInt(0, nameList.size)

        return if (value < 10) {
            Result.failure(IllegalArgumentException("Impossible to get value"))
        } else {
            Result.success(nameList[value])
        }

    }

}