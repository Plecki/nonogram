import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec

class BoardConverterTest : ShouldSpec({

    should("throw exception when converting from empty file") {
        // given
        val converter = BoardConverter()

        // when, then
        shouldThrow<IllegalArgumentException> { converter.convert(emptyList()) }
    }

}) {
    companion object Fixtures {
        val LINES: List<String> = listOf()
    }
}