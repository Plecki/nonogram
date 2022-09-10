import domain.BoardDefinition
import domain.LineDefinition

class BoardDefinitionConverter {
    fun convert(lines: List<String>): BoardDefinition {
        if (lines.isEmpty())
            throw IllegalArgumentException("Board cannot be empty")

        return BoardDefinition(listOf(LineDefinition()), listOf(LineDefinition()))
    }
}
