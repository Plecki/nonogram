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
""".trimIndent()
    }

    should("create board one row and multiple columns") {
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
""".trimIndent()
    }

    should("create board one row and multiple columns of different sizes") {
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
""".trimIndent()
    }

    should("create board multiple rows and one column") {
        // given
        val boardDefinition = boardDefinition {
            +row(1)
            +row(1)
            +row(1)
            +column(3)
        }
        val boardState = ArrayBoardState.fromString("X\n-\nX")
        val boardWithState = BoardWithState(boardDefinition, boardState)

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardWithState)

        // then
        boardToPresent shouldBe """
  3
1 X
1  
1 X
""".trimIndent()
    }

    should("create board multiple rows with more than one value and one column") {
        // given
        val boardDefinition = boardDefinition {
            +row(1, 2, 5)
            +row(1)
            +row(1, 3)
            +column(1)
        }
        val boardState = ArrayBoardState.fromString("X\n-\nX")
        val boardWithState = BoardWithState(boardDefinition, boardState)

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardWithState)

        // then
        boardToPresent shouldBe """
      1
1 2 5 X
    1  
  1 3 X
""".trimIndent()
    }

    should("create board multiple rows and multiple columns with more than one value") {
        // given
        val boardDefinition = boardDefinition {
            +row(1, 2, 5)
            +row(1)
            +row(1, 3)
            +column(2, 5)
            +column(1, 3, 4)
            +column(7, 8)
        }
        val boardState = ArrayBoardState.fromString("X-X\n-X-\nXXX")
        val boardWithState = BoardWithState(boardDefinition, boardState)

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardWithState)

        // then
        boardToPresent shouldBe """
        1  
      2 3 7
      5 4 8
1 2 5 X   X
    1   X  
  1 3 X X X
""".trimIndent()
    }
})
