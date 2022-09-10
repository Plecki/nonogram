import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class RowColSplitterTest : ShouldSpec({

    should("throw exception when there are no lines") {
        shouldThrow<IllegalArgumentException> { RowColSplitter().splitRowsAndCols(listOf()) }
    }

    should("throw exception when no blank line is present") {
        shouldThrow<IllegalArgumentException> { RowColSplitter().splitRowsAndCols(listOf("1", "1")) }
    }

    should("throw exception when rows are empty") {
        shouldThrow<IllegalArgumentException> { RowColSplitter().splitRowsAndCols(listOf("", "1")) }
    }

    should("throw exception when columns are empty") {
        shouldThrow<IllegalArgumentException> { RowColSplitter().splitRowsAndCols(listOf("1", "")) }
    }

    should("throw exception when there are multiple blank lines") {
        shouldThrow<IllegalArgumentException> { RowColSplitter().splitRowsAndCols(listOf("1", "", " ", "1")) }
    }

    should("split rows and columns by an empty string line") {
        val (rows, cols) = RowColSplitter().splitRowsAndCols(listOf("1", "2", "", "5", "3"))

        rows shouldBe listOf("1", "2")
        cols shouldBe listOf("5", "3")
    }

    should("split rows and columns by line with whitespaces") {
        val (rows, cols) = RowColSplitter().splitRowsAndCols(listOf("1", "2", " \t", "5", "3"))

        rows shouldBe listOf("1", "2")
        cols shouldBe listOf("5", "3")
    }
})
