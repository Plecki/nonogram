import domain.BoardDefinition
import domain.LineDefinition

class BoardDefinitionConverter(
    private val rowColSplitter: RowColSplitter
) {
    fun convert(lines: List<String>): BoardDefinition {
        if (lines.isEmpty())
            throw IllegalArgumentException("Board cannot be empty")

        val (rows, cols) = rowColSplitter.splitRowsAndCols(lines)

        return BoardDefinition(listOf(LineDefinition()), listOf(LineDefinition()))
    }
}
