package usecase

import domain.state.BoardState
import domain.state.CellPosition
import domain.state.CellState

interface UpdateCellStateUseCase {

    fun updateWith(cellPosition: CellPosition, cellState: CellState): BoardState

}