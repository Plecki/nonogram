package com.example.nonogram

import domain.BoardDefinition
import port.presentation.NonogramPresentation

class TerminalPresentation : NonogramPresentation {
    override fun present(nonogram: BoardDefinition) {
        println("com.example.nonogram.TerminalPresentation presentation")
        println(nonogram.toString())
    }
}