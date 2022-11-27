package domain.model.definition

import io.kotest.core.spec.style.ShouldSpec
import org.junit.jupiter.api.assertThrows

class BoardDefinitionTest : ShouldSpec({

    should("fail with empty rows") {
        assertThrows<IllegalArgumentException> { BoardDefinition(listOf(), listOf(LineDefinition(1))) }
    }

    should("fail with empty columns") {
        assertThrows<IllegalArgumentException> { BoardDefinition(listOf(LineDefinition(1)), listOf()) }
    }
})
