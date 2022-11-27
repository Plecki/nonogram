package domain.model.definition

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class LineDefinitionTest : StringSpec({

    "definition from varargs equal to definition from a list" {
        assertEquals(
            LineDefinition(listOf(1, 5, 2)),
            LineDefinition(1, 5, 2)
        )
    }

    "definition with max line size from varargs equal to definition from a list"{
        assertEquals(
            LineDefinition(listOf(63, 1, 3), maxLineSize = 80),
            LineDefinition(63, 1, 3, maxLineSize = 80)
        )
    }

    "fail when definition cannot fit in max line size" {
        listOf(
            listOf(2) to 1,
            listOf(1, 1) to 2,
            listOf(1, 2) to 3,
            listOf(1, 5, 3) to 10,
        ).forAll { (definitionValues, maxLineSize) ->
            assertThrows<IllegalArgumentException> { LineDefinition(definitionValues, maxLineSize = maxLineSize) }
        }
    }

    "pass when definition just fits in max line size" {
        listOf(
            listOf(2) to 2,
            listOf(1, 1) to 3,
            listOf(1, 2) to 4,
            listOf(1, 5, 3) to 11,
        ).forAll { (definitionValues, maxLineSize) ->
            assertDoesNotThrow { LineDefinition(definitionValues, maxLineSize = maxLineSize) }
        }
    }
})
