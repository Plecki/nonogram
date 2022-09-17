package domain.model.definition

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BoardDefinitionDSLTest : ShouldSpec({

    should("create an empty board") {
        val (rows, columns) = boardDefinition {}

        rows.size shouldBe 0
        columns.size shouldBe 0
    }

    should("create a board with one row") {
        val (rows, columns) = boardDefinition {
            +row(1, 3)
        }

        rows.size shouldBe 1
        columns.size shouldBe 0
        rows[0].values shouldBe listOf(1, 3)
    }

    should("create a board with one column") {
        val (rows, columns) = boardDefinition {
            +column()
        }

        rows.size shouldBe 0
        columns.size shouldBe 1
    }

    should("create a board with multiple rows") {
        val (rows, columns) = boardDefinition {
            +row()
            +row {
                values = listOf()
            }
        }

        rows.size shouldBe 2
        columns.size shouldBe 0
    }

    should("create a board with multiple columns") {
        val (rows, columns) = boardDefinition {
            +column()
            +column {
                values = listOf()
            }
        }

        rows.size shouldBe 0
        columns.size shouldBe 2
    }

    should("create a board with multiple rows and columns") {
        val (rows, columns) = boardDefinition {
            +row()
            +row {
                values = listOf()
            }
            +column()
            +column {
                values = listOf()
            }
        }

        rows.size shouldBe 2
        columns.size shouldBe 2
    }
})

