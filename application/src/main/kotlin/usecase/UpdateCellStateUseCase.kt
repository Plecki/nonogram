package usecase

import domain.model.state.BoardState
import domain.model.state.CellPosition
import domain.model.state.CellState

interface UpdateCellStateUseCase {

    fun updateWith(cellPosition: CellPosition, cellState: CellState): BoardState

}