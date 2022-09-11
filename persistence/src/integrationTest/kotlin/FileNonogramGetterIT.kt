import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.io.File

class FileNonogramGetterIT : ShouldSpec({

    should("create a board from file") {
        // given
        val boardDefinitionConverter = BoardDefinitionConverter(RowColSplitter(), LineDefinitionConverter())
        val file = File(this::class.java.classLoader.getResource("simple-nonogram.txt").toURI())
        val fileNonogramGetter = FileNonogramGetter(file, boardDefinitionConverter)

        // when
        val nonogramBoardDefinition = fileNonogramGetter.getNonogram()

        // then
        val rows = nonogramBoardDefinition.rows
        rows.size shouldBe 3
        rows[0].values shouldBe listOf(2)
        rows[1].values shouldBe listOf(1, 3)
        rows[2].values shouldBe listOf(1, 1)

        val cols = nonogramBoardDefinition.columns
        cols.size shouldBe 4
        cols[0].values shouldBe listOf(4)
        cols[1].values shouldBe listOf(2, 3, 3)
        cols[2].values shouldBe listOf(1, 5)
        cols[3].values shouldBe listOf(2, 1)
    }
})
