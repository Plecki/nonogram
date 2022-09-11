package usecase

import domain.state.ArrayBoardState
import domain.state.BoardState
import domain.state.CellPosition
import domain.state.CellState

class UpdateCellStateUseCaseImpl : UpdateCellStateUseCase {
    override fun updateWith(cellPosition: CellPosition, cellState: CellState): BoardState {
        // TODO really update state
        return ArrayBoardState.createEmpty(5, 5)
            .withUpdatedCell(CellPosition(2, 2), CellState(true))
    }
}
