package domain.model.state

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

    should("empty 1x1 board is not solved") {
        ArrayBoardState(listOf(listOf(CellState(false)))).isSolved() shouldBe false
    }

    should("full 1x1 board is solved") {
        ArrayBoardState(listOf(listOf(CellState(true)))).isSolved() shouldBe true
    }

    should("require cell position actually in board") {
        val arrayBoardState = ArrayBoardState.createEmpty(2, 1)

        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(-1, 0), CellState(true)) }
        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(0, -1), CellState(true)) }
        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(0, 1), CellState(true)) }
        shouldThrow<IllegalArgumentException> { arrayBoardState.withUpdatedCell(CellPosition(2, 0), CellState(true)) }

        shouldNotThrowAny { arrayBoardState.withUpdatedCell(CellPosition(0, 0), CellState(true)) }
        shouldNotThrowAny { arrayBoardState.withUpdatedCell(CellPosition(1, 0), CellState(true)) }
    }

    should("update state only if it changes") {
        val arrayBoardState = ArrayBoardState.createEmpty(2, 1)

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
        val arrayBoardState = ArrayBoardState.createEmpty(2, 2)

        val boardWithUpdatedCell = arrayBoardState.withUpdatedCell(CellPosition(1, 0), CellState(true))

        boardWithUpdatedCell.getStateOf(0, 0) shouldBe CellState(false)
        boardWithUpdatedCell.getStateOf(0, 1) shouldBe CellState(false)
        boardWithUpdatedCell.getStateOf(1, 0) shouldBe CellState(true)
        boardWithUpdatedCell.getStateOf(1, 1) shouldBe CellState(false)
    }
})
