import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class BoardConverterTest : ShouldSpec({

    should("throw exception when converting from empty file") {
        // given
        val converter = BoardConverter()

        // when, then
        shouldThrow<IllegalArgumentException> { converter.convert(emptyList()) }
    }

    should("convert a board with one row and column") {
        val converter = BoardConverter()

        val board = converter.convert(listOf("1", "1"))

        board.getRows().size shouldBe 1
        board.getColumns().size shouldBe 1
    }

}) {
    companion object Fixtures {
        val LINES: List<String> = listOf()
    }
}