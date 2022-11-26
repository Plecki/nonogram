package com.example.nonogram.terminal

import domain.model.BoardWithState
import domain.model.definition.LineDefinition
import domain.model.state.BoardState
import domain.model.state.CellState
import port.presentation.NonogramPresentation

class TerminalPresentation : NonogramPresentation {
    override fun present(boardWithState: BoardWithState) {
        println("TerminalPresentation presents:")
        println(createBoardToPresent(boardWithState))
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
            .map { id -> columnDefinitions.map { it.values.getOrNull(it.values.size - maxSize + id) } }
            .map { line -> line.map { it?.toString() ?: " " } }
            .map { it.joinToString(separator = " ") }
    }

    private fun appendedWithSpaces(numberOfSpaces: Int, rowsForColumnDefinitions: List<String>): List<String> {
        return rowsForColumnDefinitions
            .map { " ".repeat(numberOfSpaces * 2) + it }
    }

    private fun rowsForRowDefinitionsAndState(boardWithState: BoardWithState): List<String> {
        val rowsForRowDefinitions = rowsForRowDefinitions(boardWithState.boardDefinition.rows)
        val rowsForState = rowsForState(boardWithState.boardState)
        return rowsForRowDefinitions
            .mapIndexed { id, row -> row + " " + rowsForState[id] }
    }

    private fun rowsForRowDefinitions(rows: List<LineDefinition>): List<String> {
        val maxRowSize = rows
            .maxOf { it.values.size }

        return rows.map { lineDefinition ->
            (0 until maxRowSize)
                .map { id -> lineDefinition.values.getOrNull(lineDefinition.values.size - maxRowSize + id) }
                .map { it?.toString() ?: " " }
                .joinToString(separator = " ")
        }
    }

    private fun rowsForState(boardState: BoardState): List<String> {
        return boardState.getRows()
            .map {
                it.cellStates
                    .joinToString(separator = " ") { mapCellState(it) }
            }
    }

    private fun mapCellState(cellState: CellState): String = if (cellState.state) "X" else " "

    private fun <T> concatenate(vararg rows: List<T>) = listOf(*rows).flatten()
}