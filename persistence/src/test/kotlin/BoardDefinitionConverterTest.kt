import domain.model.definition.LineDefinition
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class BoardDefinitionConverterTest : ShouldSpec({
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
        val rowsConverted = mockk<List<String>>()
        val colsConverted = mockk<List<String>>()
        every { rowColSplitter.splitRowsAndCols(any()) } returns (rowsConverted to colsConverted)
        val expectedRowDefinitions = listOf<LineDefinition>(mockk())
        val expectedColDefinitions = listOf<LineDefinition>(mockk())
        every { lineDefinitionConverter.convert(rowsConverted) } returns expectedRowDefinitions
        every { lineDefinitionConverter.convert(colsConverted) } returns expectedColDefinitions

        // when
        val boardDefinition = BoardDefinitionConverter(rowColSplitter, lineDefinitionConverter)
            .convert(listOf("1 2", "3 4"))

        // then
        boardDefinition.rows shouldBe expectedRowDefinitions
        boardDefinition.columns shouldBe expectedColDefinitions
    }
})
