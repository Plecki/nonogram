package com.example.nonogram

import com.example.nonogram.terminal.TerminalPresentation
import domain.model.BoardWithState
import domain.model.definition.boardDefinition
import domain.model.definition.column
import domain.model.definition.row
import domain.model.state.ArrayBoardState
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class TerminalPresentationTest : ShouldSpec({

    should("create board to present with one row and column with one one-digit value each") {
        // given
        val boardDefinition = boardDefinition {
            +row(1)
            +column(1)
        }

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardDefinition)

        // then
        boardToPresent shouldBe """
  1
1            """.trimIndent().trimEnd()
    }

    should("create board to present with multiple rows and columns with one one-digit value each") {
        // given
        val boardDefinition = boardDefinition {
            +row(1)
            +row(3)
            +row(5)
            +column(4)
            +column(2)
        }

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardDefinition)

        // then
        boardToPresent shouldBe """
  4 2
1
3
5         """.trimIndent().trimEnd()
    }

    should("create board one row and column ad full board state") {
        // given
        val boardDefinition = boardDefinition {
            +row(1)
            +column(1)
        }
        val boardState = ArrayBoardState.fromString("X")
        val boardWithState = BoardWithState(boardDefinition, boardState)

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardWithState)

        // then
        boardToPresent shouldBe """
  1
1 X
""".trimIndent().trimEnd()
    }

    should("create board one row and multiple columns and full board state") {
        // given
        val boardDefinition = boardDefinition {
            +row(1)
            +column(1, 2)
            +column(3, 4)
        }
        val boardState = ArrayBoardState.fromString("X-")
        val boardWithState = BoardWithState(boardDefinition, boardState)

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardWithState)

        // then
        boardToPresent shouldBe """
  1 3
  2 4
1 X
""".trimIndent().trimEnd()
    }

    should("create board one row and multiple columns of different sizes and full board state") {
        // given
        val boardDefinition = boardDefinition {
            +row(1)
            +column(2, 5)
            +column(1, 3, 4)
            +column(7, 8)
        }
        val boardState = ArrayBoardState.fromString("X--")
        val boardWithState = BoardWithState(boardDefinition, boardState)

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardWithState)

        // then
        boardToPresent shouldBe """
    1  
  2 3 7
  5 4 8
1 X
""".trimIndent().trimEnd()
    }
})
