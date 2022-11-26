package com.example.nonogram.terminal

import domain.model.BoardWithState
import domain.model.definition.BoardDefinition
import port.presentation.NonogramPresentation

class TerminalPresentation : NonogramPresentation {
    override fun present(boardWithState: BoardWithState) {
        println("TerminalPresentation presents:")
        println(createBoardToPresent(boardWithState.boardDefinition))
    }

    fun createBoardToPresent(boardWithState: BoardWithState): String {
        return rowsFrom(boardWithState).joinToString(separator = "\n")
    }

    private fun rowsFrom(boardWithState: BoardWithState): List<String> {
        val rowsForColumnDefinitions = rowsForColumnDefinitions(boardWithState.boardDefinition.columns)
        val rowsForRowDefinitionsAndState = rowsForRowDefinitionsAndState(boardWithState)
        return concatenate(rowsForColumnDefinitions, rowsForRowDefinitionsAndState)
    }

    private fun rowsForColumnDefinitions(columns: List<Any>): List<String> {
        return listOf("  1")
    }

    private fun rowsForRowDefinitionsAndState(boardWithState: BoardWithState): List<String> {
        return listOf("1 X")
    }

    private fun concatenate(vararg rows: List<String>) = listOf(*rows).flatten()

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