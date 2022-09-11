package usecase

import domain.state.ArrayBoardState
import domain.state.BoardState
import domain.state.CellPosition
import domain.state.CellState
import java.util.*

class UpdateCellStateUseCaseImpl : UpdateCellStateUseCase {
    override fun updateWith(cellPosition: CellPosition, cellState: CellState): BoardState {
        // TODO really update state
        return ArrayBoardState.createEmpty(5, 5)
            .withUpdatedCell(CellPosition(Random().nextInt(3), Random().nextInt(3)), CellState(true))
    }
}
