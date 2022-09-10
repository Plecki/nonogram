import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class LineDefinitionConverterTest : ShouldSpec({

    should("throw exception when converting non-number line") {
        shouldThrow<NumberFormatException> { LineDefinitionConverter().convert("#") }
        shouldThrow<NumberFormatException> { LineDefinitionConverter().convert("U") }
        shouldThrow<NumberFormatException> { LineDefinitionConverter().convert("5 2 F 4") }
        shouldThrow<NumberFormatException> { LineDefinitionConverter().convert("7G") }
    }

    should("convert line with a number") {
        LineDefinitionConverter().convert("7").getValues() shouldBe listOf(7)
        LineDefinitionConverter().convert("84").getValues() shouldBe listOf(84)
    }

    should("convert line with multiple numbers") {
        LineDefinitionConverter().convert("7 91 3").getValues() shouldBe listOf(7, 91, 3)
    }

    should("throw exception when there are empty lines") {
        shouldThrow<IllegalArgumentException> { LineDefinitionConverter().convert(listOf("1", "", "2 4")) }
    }

    should("throw exception when there are non-numbers in at least one line") {
        shouldThrow<NumberFormatException> { LineDefinitionConverter().convert(listOf("F", "#", "1")) }
        shouldThrow<NumberFormatException> { LineDefinitionConverter().convert(listOf("3", "1 F")) }
        shouldThrow<NumberFormatException> { LineDefinitionConverter().convert(listOf("5", "# 1")) }
    }

    should("convert single numbers") {
        val lineDefinitions = LineDefinitionConverter().convert(listOf("37", "15", "1"))

        lineDefinitions.size shouldBe 3
        lineDefinitions[0].getValues() shouldBe listOf(37)
        lineDefinitions[1].getValues() shouldBe listOf(15)
        lineDefinitions[2].getValues() shouldBe listOf(1)
    }
})
