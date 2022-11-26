package com.example.nonogram

import com.example.nonogram.terminal.TerminalPresentation
import domain.model.definition.boardDefinition
import domain.model.definition.column
import domain.model.definition.row
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
})
