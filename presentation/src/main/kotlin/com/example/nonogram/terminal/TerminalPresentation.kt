package com.example.nonogram.terminal

import domain.BoardDefinition
import port.presentation.NonogramPresentation

class TerminalPresentation : NonogramPresentation {
    override fun present(nonogram: BoardDefinition) {
        println("TerminalPresentation presents:")
        println(createBoardToPresent(nonogram))
    }

    fun createBoardToPresent(nonogram: BoardDefinition): String {
        val initialSpaces = "  "

        val columnsToPresent: String =
            nonogram.columns
                .map { it.values[0] }
                .map { it.toString() }
                .joinToString(separator = " ")

        val rowsToPresent: String =
            nonogram.rows
                .map { it.values[0] }
                .map { it.toString() }
                .joinToString(separator = "\n")

        return initialSpaces + columnsToPresent + "\n" + rowsToPresent
    }
}