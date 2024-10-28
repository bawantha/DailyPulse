package com.bawantha.dailypulse

expect class Platform {
    val osName: String
    val osVersion: String
    val deviceVersion: String
    val density: Int
    fun logSystemInfo()
}
