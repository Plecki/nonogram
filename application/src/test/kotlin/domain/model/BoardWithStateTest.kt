package domain.model

import domain.model.definition.BoardDefinition
import domain.model.definition.LineDefinition
import domain.model.state.ArrayBoardState
import domain.model.state.CellState
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BoardWithStateTest : ShouldSpec({

    should("empty 1x1 board is not solved") {
        BoardWithState(
            BoardDefinition(listOf(LineDefinition(listOf(1))), listOf(LineDefinition(listOf(1)))),
            ArrayBoardState(listOf(listOf(CellState(false))))
        ).isSolved() shouldBe false
    }

    should("full 1x1 board is solved") {
        BoardWithState(
            BoardDefinition(listOf(LineDefinition(listOf(1))), listOf(LineDefinition(listOf(1)))),
            ArrayBoardState(listOf(listOf(CellState(true))))
        ).isSolved() shouldBe true
    }
})
