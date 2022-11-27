import domain.model.definition.LineDefinition
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class BoardDefinitionConverterWithMocksTest : ShouldSpec({
    val rowColSplitter = mockk<RowColSplitter>()
    val lineDefinitionConverter = mockk<LineDefinitionConverter>()

    should("fail when lines are empty") {
        shouldThrow<IllegalArgumentException> {
            BoardDefinitionConverter(rowColSplitter, lineDefinitionConverter)
                .convert(emptyList())
        }
    }

    should("create a board definition when row and col definitions have been converted") {
        // given
        val rowsSplit = listOf("1 2", "2", "1")
        val colsSplit = listOf("1 1", "3", "2", "1 1")
        every { rowColSplitter.splitRowsAndCols(any()) } returns (rowsSplit to colsSplit)
        val expectedRowDefinitions = listOf<LineDefinition>(mockk())
        val expectedColDefinitions = listOf<LineDefinition>(mockk())
        every { lineDefinitionConverter.convert(rowsSplit, colsSplit.size) } returns expectedRowDefinitions
        every { lineDefinitionConverter.convert(colsSplit, rowsSplit.size) } returns expectedColDefinitions

        // when
        val boardDefinition = BoardDefinitionConverter(rowColSplitter, lineDefinitionConverter)
            .convert(listOf("1 2", "2", "1", "\n", "1 1", "3", "2", "1 1"))

        // then
        boardDefinition.rows shouldBe expectedRowDefinitions
        boardDefinition.columns shouldBe expectedColDefinitions
    }
})
