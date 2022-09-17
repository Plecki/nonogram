package domain.model.state

interface BoardState {

    fun isSolved(): Boolean

    fun getStateOf(rowId: Int, columnId: Int): CellState

    fun withUpdatedCell(
        cellPosition: CellPosition,
        newCellState: CellState,
        failIfAlreadySet: Boolean = false
    ): BoardState

}
