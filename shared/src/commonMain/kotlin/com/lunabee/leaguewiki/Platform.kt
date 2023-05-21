package com.lunabee.leaguewiki

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform