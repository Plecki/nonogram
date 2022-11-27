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
        rows.size shouldBe 5
        rows[0].values shouldBe listOf(1, 1, 3)
        rows[1].values shouldBe listOf(1, 1, 2)
        rows[2].values shouldBe listOf(1, 1, 2)
        rows[3].values shouldBe listOf(2, 2, 1)
        rows[4].values shouldBe listOf(1, 1)

        val columns = nonogramBoardDefinition.columns
        columns.size shouldBe 7
        columns[0].values shouldBe listOf(1, 3)
        columns[1].values shouldBe listOf(2, 1)
        columns[2].values shouldBe listOf(1, 1, 1)
        columns[3].values shouldBe listOf(2, 1)
        columns[4].values shouldBe listOf(5)
        columns[5].values shouldBe listOf(3, 1)
        columns[6].values shouldBe listOf(4)
    }
})
