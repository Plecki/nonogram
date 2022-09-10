package com.example.nonogram

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
            nonogram.getColumns()
                .map { it.getValues()[0] }
                .map { it.toString() }
                .joinToString(separator = " ")

        val rowsToPresent: String =
            nonogram.getRows()
                .map { it.getValues()[0] }
                .map { it.toString() }
                .joinToString(separator = "\n")

        return initialSpaces + columnsToPresent + "\n" + rowsToPresent
    }
}