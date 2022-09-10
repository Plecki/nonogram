package com.example.nonogram

import domain.Board
import port.presentation.NonogramPresentation

class TerminalPresentation : NonogramPresentation {
    override fun present(nonogram: Board) {
        println("com.example.nonogram.TerminalPresentation presentation")
    }
}