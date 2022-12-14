import domain.model.definition.BoardDefinition

class BoardDefinitionConverter(
    private val rowColSplitter: RowColSplitter,
    private val lineDefinitionConverter: LineDefinitionConverter
) {
    fun convert(lines: List<String>): BoardDefinition {
        if (lines.isEmpty())
            throw IllegalArgumentException("Board cannot be empty")

        val (rows, cols) = rowColSplitter.splitRowsAndCols(lines)
        val rowsDefinitions = lineDefinitionConverter.convert(rows, maxLineSize = cols.size)
        val colsDefinitions = lineDefinitionConverter.convert(cols, maxLineSize = rows.size)

        return BoardDefinition(
            rowsDefinitions,
            colsDefinitions
        )
    }
}
