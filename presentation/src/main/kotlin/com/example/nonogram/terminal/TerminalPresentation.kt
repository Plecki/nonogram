package com.example.nonogram.terminal

import domain.model.BoardWithState
import domain.model.definition.BoardDefinition
import port.presentation.NonogramPresentation

class TerminalPresentation : NonogramPresentation {
    override fun present(boardWithState: BoardWithState) {
        println("TerminalPresentation presents:")
        println(createBoardToPresent(boardWithState.boardDefinition))
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