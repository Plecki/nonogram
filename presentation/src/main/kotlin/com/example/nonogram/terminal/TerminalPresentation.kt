package com.example.nonogram.terminal

import domain.model.BoardWithState
import domain.model.definition.BoardDefinition
import domain.model.definition.LineDefinition
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
        val numberOfSpaces = boardWithState.boardDefinition.rows.maxOf { it.values.size }
        val rowsForColumnDefinitions =
            appendedWithSpaces(numberOfSpaces, rowsForColumnDefinitions(boardWithState.boardDefinition.columns))
        val rowsForRowDefinitionsAndState = rowsForRowDefinitionsAndState(boardWithState)
        return concatenate(rowsForColumnDefinitions, rowsForRowDefinitionsAndState)
    }

    private fun rowsForColumnDefinitions(columnDefinitions: List<LineDefinition>): List<String> {
        val maxSize = columnDefinitions
            .map { it.values.size }
            .maxOf { it }
        return (0 until maxSize)
            .map { id -> columnDefinitions.map { it.values.getOrNull(id) } }
            .map { line -> line.map { it?.toString() ?: " " } }
            .map { it.joinToString(separator = " ") }
    }

    private fun appendedWithSpaces(numberOfSpaces: Int, rowsForColumnDefinitions: List<String>): List<String> {
        return rowsForColumnDefinitions
            .map { " ".repeat(numberOfSpaces * 2) + it }
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