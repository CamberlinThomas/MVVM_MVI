package com.example.idata

import com.example.idomain.IAgeRepository
import kotlin.random.Random

class AgeRepository: IAgeRepository {

    override fun getAge()= Random.nextInt(0, 5)

}