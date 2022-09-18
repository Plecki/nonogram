package domain.model

import domain.model.definition.boardDefinition
import domain.model.definition.column
import domain.model.definition.row
import domain.model.state.ArrayBoardState
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BoardWithStateTest : ShouldSpec({

    should("not throw exception when definition and state have the same shapes") {
        shouldNotThrowAny {
            BoardWithState(
                boardDefinition {
                    +row(1)
                    +row(1)
                    +column(1)
                    +column(1)
                    +column(1)
                },
                ArrayBoardState.createEmpty(2, 3)
            )
        }
    }

    should("throw exception when definition and state have different shapes") {
        shouldThrow<IllegalArgumentException> {
            BoardWithState(
                boardDefinition {
                    +row(1)
                    +row(1)
                    +column(1)
                },
                ArrayBoardState.createEmpty(2, 3)
            )
        }
    }

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

    should("2x2 board recognize solved") {
        BoardWithState(
            boardDefinition {
                +row(1)
                +row(2)
                +column(1)
                +column(2)
            },
            ArrayBoardState.fromString("-X\nXX")
        ).isSolved() shouldBe true
    }
})
