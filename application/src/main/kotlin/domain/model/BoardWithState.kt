package domain.model

import domain.model.definition.BoardDefinition
import domain.model.state.BoardState

data class BoardWithState(
    val boardDefinition: BoardDefinition,
    val boardState: BoardState,
) {
    init {
        require(boardDefinition.numberOfColumns() == boardState.numberOfColumns())
        require(boardDefinition.numberOfRows() == boardState.numberOfRows())
    }

    fun isSolved(): Boolean {
        return linesWithState(boardDefinition, boardState)
            .all { it.isSolved() }
    }

    private fun linesWithState(
        boardDefinition: BoardDefinition,
        boardState: BoardState,
    ) = sequence {
        for ((i, row) in boardDefinition.rows.withIndex()) {
            yield(LineWithState(row, boardState.getRows()[i], boardDefinition.numberOfColumns()))
        }
        for ((i, column) in boardDefinition.columns.withIndex()) {
            yield(LineWithState(column, boardState.getColumns()[i], boardDefinition.numberOfRows()))
        }
    }
}
