package domain.state

interface BoardState {

    fun getStateOf(rowId: Int, columnId: Int): CellState

    fun withUpdatedCell(
        cellPosition: CellPosition,
        newCellState: CellState,
        failIfAlreadySet: Boolean = false
    ): BoardState

}
