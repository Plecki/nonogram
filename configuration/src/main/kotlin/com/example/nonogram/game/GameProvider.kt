package com.example.nonogram.game

import com.example.nonogram.configuration.ConfigurationProperties
import com.example.nonogram.desktop.DesktopGame
import com.example.nonogram.terminal.TerminalGame
import usecase.NonogramGame

class GameProvider(
    private val configurationProperties: ConfigurationProperties,
    private val terminalGame: TerminalGame,
    private val desktopGame: DesktopGame,
) {

    fun provide(): NonogramGame {
        return when (configurationProperties.getGameMode()) {
            GameMode.TERMINAL -> terminalGame
            GameMode.DESKTOP -> desktopGame
        }
    }
}