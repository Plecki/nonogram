package domain.model.state

interface BoardState {

    fun getStateOf(rowId: Int, columnId: Int): CellState

    fun withUpdatedCell(
        cellPosition: CellPosition,
        newCellState: CellState,
        failIfAlreadySet: Boolean = false
    ): BoardState

    fun numberOfColumns(): Int

    fun numberOfRows(): Int

}
