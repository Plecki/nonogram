package com.example.nonogram

import com.example.nonogram.terminal.TerminalPresentation
import domain.BoardDefinition
import domain.LineDefinition
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class TerminalPresentationTest : ShouldSpec({

    should("create board to present with one row and column with one one-digit value each") {
        // given
        val rows = listOf(LineDefinition(listOf(1)))
        val cols = listOf(LineDefinition(listOf(1)))
        val boardDefinition = BoardDefinition(rows, cols)

        // when
        val boardToPresent: String = TerminalPresentation().createBoardToPresent(boardDefinition)

        // then
        boardToPresent shouldBe """
  1
1            """.trimIndent().trimEnd()
    }

    should("create board to present with multiple rows and columns with one one-digit value each") {
        // given
        val rows = listOf(LineDefinition(listOf(1)), LineDefinition(listOf(3)), LineDefinition(listOf(5)))
        val cols = listOf(LineDefinition(listOf(4)), LineDefinition(listOf(2)))
        val boardDefinition = BoardDefinition(rows, cols)

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
