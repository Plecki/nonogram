import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BoardConverterTest : ShouldSpec({

    should("throw exception when converting from empty file") {
        // given
        val converter = BoardDefinitionConverter(RowColSplitter(), LineDefinitionConverter())

        // when, then
        shouldThrow<IllegalArgumentException> { converter.convert(emptyList()) }
    }

    should("convert a board with one row and column with one value each") {
        // given
        val converter = BoardDefinitionConverter(RowColSplitter(), LineDefinitionConverter())

        // when
        val board = converter.convert(
            listOf(
                "1",
                "",
                "1"
            )
        )

        // then
        val rows = board.rows
        rows.size shouldBe 1
        rows[0].values shouldBe listOf(1)

        val columns = board.columns
        columns.size shouldBe 1
        columns[0].values shouldBe listOf(1)
    }

    should("convert a board with multiple rows and columns with one value each") {
        // given
        val converter = BoardDefinitionConverter(RowColSplitter(), LineDefinitionConverter())

        // when
        val board = converter.convert(
            listOf(
                "2", "2", "1",
                "",
                "1", "1", "1", "2"
            )
        )

        // then
        val rows = board.rows
        rows.size shouldBe 3
        rows[0].values shouldBe listOf(2)
        rows[1].values shouldBe listOf(2)
        rows[2].values shouldBe listOf(1)

        val columns = board.columns
        columns.size shouldBe 4
        columns[0].values shouldBe listOf(1)
        columns[1].values shouldBe listOf(1)
        columns[2].values shouldBe listOf(1)
        columns[3].values shouldBe listOf(2)
    }

    should("convert a board with multiple rows and columns with multiple value each") {
        // given
        val converter = BoardDefinitionConverter(RowColSplitter(), LineDefinitionConverter())

        // when
        val board = converter.convert(
            listOf(
                "2 3 5", "2 27",
                "",
                "1 4 1", "23 53"
            )
        )

        // then
        val rows = board.rows
        rows.size shouldBe 2
        rows[0].values shouldBe listOf(2, 3, 5)
        rows[1].values shouldBe listOf(2, 27)

        val columns = board.columns
        columns.size shouldBe 2
        columns[0].values shouldBe listOf(1, 4, 1)
        columns[1].values shouldBe listOf(23, 53)
    }
})