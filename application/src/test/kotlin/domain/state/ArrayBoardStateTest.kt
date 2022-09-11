package domain.state

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ArrayBoardStateTest : ShouldSpec({

    should("require each column to be the same size") {
        val rowWith3values = listOf(CellState(true), CellState(false), CellState(true))
        val rowWith2values = listOf(CellState(true), CellState(false))
        val state = listOf(rowWith3values, rowWith2values)
        shouldThrow<IllegalArgumentException> { ArrayBoardState(state) }
    }

    should("create state") {
        val row = listOf(CellState(true), CellState(false), CellState(true))
        val state = listOf(row, row, row, row)
        shouldNotThrowAny { ArrayBoardState(state) }
    }

    should("require cell position actually in board") {
        val arrayBoardState = createBoardState(2, 1)

        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(-1, 0), CellState(true)) }
        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(0, -1), CellState(true)) }
        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(0, 1), CellState(true)) }
        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(2, 0), CellState(true)) }

        shouldNotThrowAny { arrayBoardState.withUpdatedCell(CellPosition(0, 0), CellState(true)) }
        shouldNotThrowAny { arrayBoardState.withUpdatedCell(CellPosition(1, 0), CellState(true)) }
    }

    should("update state only if it changes") {
        val arrayBoardState = createBoardState(2, 1)

        shouldThrow<IllegalArgumentException> {
            arrayBoardState.withUpdatedCell(
                CellPosition(0, 0),
                CellState(false),
                failIfAlreadySet = true
            )
        }
        shouldNotThrowAny {
            arrayBoardState.withUpdatedCell(
                CellPosition(0, 0),
                CellState(false),
                failIfAlreadySet = false
            )
        }
    }

    should("update state of cell") {
        val arrayBoardState = createBoardState(2, 2)

        val boardWithUpdatedCell = arrayBoardState.withUpdatedCell(CellPosition(1, 0), CellState(true))

        boardWithUpdatedCell.getStateOf(0, 0) shouldBe CellState(false)
        boardWithUpdatedCell.getStateOf(0, 1) shouldBe CellState(false)
        boardWithUpdatedCell.getStateOf(1, 0) shouldBe CellState(true)
        boardWithUpdatedCell.getStateOf(1, 1) shouldBe CellState(false)
    }
})

private fun createBoardState(numberOfRows: Int, numberOfColumns: Int): ArrayBoardState {
    val row = List(numberOfColumns) { CellState(false) }
    val state = List(numberOfRows) { row }
    return ArrayBoardState(state)
}
