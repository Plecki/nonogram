package com.example.nonogram.game

enum class GameMode(private val propertyName: String) {
    TERMINAL("terminal"),
    DESKTOP("desktop");

    companion object {
        fun fromProperty(propertyName: String): GameMode {
            return values().first { it.propertyName == propertyName }
        }
    }
}