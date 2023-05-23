package com.lunabee.leaguewiki

import com.lunabee.domain.model.TestData

class Greeting {
    fun greet(): String {
        return TestData().toString() //"Hello, ${platform.name}!"
    }
}