package usecase

import domain.BoardWithState
import domain.state.BoardState
import domain.state.CellPosition
import domain.state.CellState
import mu.KotlinLogging
import port.persistence.NonogramPersistence

class UpdateCellStateUseCaseImpl(
    private val nonogramPersistence: NonogramPersistence
) : UpdateCellStateUseCase {
    private val logger = KotlinLogging.logger {}

    override fun updateWith(cellPosition: CellPosition, cellState: CellState): BoardState {
        val activeBoard: BoardWithState = nonogramPersistence.getActiveBoard()
        val boardStateWithUpdatedCell = activeBoard.boardState.withUpdatedCell(cellPosition, cellState)
        logger.info { "Updating board with $boardStateWithUpdatedCell" }
        nonogramPersistence.updateCurrentState(boardStateWithUpdatedCell)
        return boardStateWithUpdatedCell
    }
}
