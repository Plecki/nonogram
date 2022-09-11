package usecase

import domain.state.ArrayBoardState
import domain.state.BoardState
import domain.state.CellPosition
import domain.state.CellState

class GetBoardStateUseCaseImpl : GetBoardStateUseCase {
    override fun getBoardState(): BoardState {
        return ArrayBoardState.createEmpty(5, 5)
            .withUpdatedCell(CellPosition(1, 1), CellState(true))
            .withUpdatedCell(CellPosition(2, 2), CellState(true))
    }
}