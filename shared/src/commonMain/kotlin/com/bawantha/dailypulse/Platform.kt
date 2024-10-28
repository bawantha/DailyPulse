package com.bawantha.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform