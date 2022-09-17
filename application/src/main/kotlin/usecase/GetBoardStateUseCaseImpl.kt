package usecase

import domain.model.state.ArrayBoardState
import domain.model.state.BoardState
import domain.model.state.CellPosition
import domain.model.state.CellState

class GetBoardStateUseCaseImpl : GetBoardStateUseCase {
    override fun getBoardState(): BoardState {
        // TODO get real state
        return ArrayBoardState.createEmpty(5, 5)
            .withUpdatedCell(CellPosition(1, 1), CellState(true))
            .withUpdatedCell(CellPosition(2, 2), CellState(true))
    }
}