package domain.model.definition

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BoardDefinitionDSLTest : ShouldSpec({

    should("throw exception when creating an empty board") {
        shouldThrow<IllegalArgumentException> { boardDefinition {} }
    }

    should("throw exception when creating a board with one row but no columns") {
        shouldThrow<IllegalArgumentException> {
            boardDefinition {
                +row(1, 3)
            }
        }
    }

    should("throw exception when creating a board with one column but no rows") {
        shouldThrow<IllegalArgumentException> {
            boardDefinition {
                +column()
            }
        }
    }

    should("throw exception when creating a board with multiple rows but no columns") {
        shouldThrow<IllegalArgumentException> {
            boardDefinition {
                +row()
                +row {
                    values = listOf()
                }
            }
        }
    }

    should("throw exception when creating a board with multiple columns but no rows") {
        shouldThrow<IllegalArgumentException> {
            boardDefinition {
                +column()
                +column {
                    values = listOf()
                }
            }
        }
    }

    should("create a board with one row and one column") {
        val (rows, columns) = boardDefinition {
            +row(1)
            +column(1)
        }

        rows.size shouldBe 1
        columns.size shouldBe 1
    }

    should("create a board with multiple rows and columns") {
        val (rows, columns) = boardDefinition {
            +row(2)
            +row {
                values = listOf(1)
            }
            +column(1)
            +column {
                values = listOf(2)
            }
        }

        rows.size shouldBe 2
        columns.size shouldBe 2
    }
})

