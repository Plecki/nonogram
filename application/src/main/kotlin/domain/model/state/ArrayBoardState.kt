package domain.model.state

data class ArrayBoardState(
    val state: List<List<CellState>>
) : BoardState {

    init {
        val rowSize = state[0].size
        for (arrayOfCellStates in state) {
            require(arrayOfCellStates.size == rowSize) {
                "Each row has to be equal size, size should be $rowSize, was ${arrayOfCellStates.size}"
            }
        }
    }

    companion object {
        fun createEmpty(numberOfRows: Int, numberOfColumns: Int): ArrayBoardState {
            val row = List(numberOfColumns) { CellState(false) }
            val state = List(numberOfRows) { row }
            return ArrayBoardState(state)
        }

        fun fromString(state: String, filled: Char = 'X', empty: Char = '-'): ArrayBoardState {
            return ArrayBoardState(
                state
                    .split("\n")
                    .map {
                        it.toCharArray()
                            .map {
                                when (it) {
                                    filled -> CellState(true)
                                    empty -> CellState(false)
                                    else -> throw IllegalArgumentException()
                                }
                            }
                    })
        }
    }

    override fun getStateOf(rowId: Int, columnId: Int): CellState {
        return state[rowId][columnId]
    }

    override fun withUpdatedCell(
        cellPosition: CellPosition,
        newCellState: CellState,
        failIfAlreadySet: Boolean
    ): ArrayBoardState {
        require(containsPosition(cellPosition))

        val currentState = state[cellPosition.getRow()][cellPosition.getColumn()]
        if (failIfAlreadySet && newCellState == currentState)
            throw IllegalArgumentException("New cell state is equal to current state of $newCellState in position $cellPosition")

        val newRow: List<CellState> = state[cellPosition.getRow()]
            .updated(
                cellPosition.getColumn(),
                newCellState
            )
        val newState: List<List<CellState>> = state
            .updated(
                cellPosition.getRow(),
                newRow
            )

        return this.copy(state = newState)
    }

    private fun containsPosition(cellPosition: CellPosition): Boolean {
        return cellPosition.getRow() >= 0 && cellPosition.getColumn() >= 0
                && cellPosition.getRow() < state.size
                && cellPosition.getColumn() < state[0].size
    }

    private fun <E> Iterable<E>.updated(index: Int, elem: E) =
        mapIndexed { i, existing -> if (i == index) elem else existing }
}

