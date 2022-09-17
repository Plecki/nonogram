package domain.model

import domain.model.definition.boardDefinition
import domain.model.definition.column
import domain.model.definition.row
import domain.model.state.ArrayBoardState
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BoardWithStateTest : ShouldSpec({

    should("empty 1x1 board is not solved") {
        BoardWithState(
            boardDefinition {
                +row(1)
                +column(1)
            },
            ArrayBoardState.fromString("-")
        ).isSolved() shouldBe false
    }

    should("full 1x1 board is solved") {
        BoardWithState(
            boardDefinition {
                +row(1)
                +column(1)
            },
            ArrayBoardState.fromString("X")
        ).isSolved() shouldBe true
    }
})
