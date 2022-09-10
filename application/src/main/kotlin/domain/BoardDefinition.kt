package domain

class BoardDefinition(
    private val rows: List<LineDefinition>,
    private val columns: List<LineDefinition>,
) {

    fun getRows(): List<LineDefinition> {
        return rows
    }

    fun getColumns(): List<LineDefinition> {
        return columns
    }

    override fun toString(): String {
        val rowsStr = rows.joinToString(separator = "\n") { it.getValues().toString() }
        val columnsStr = columns.joinToString(separator = "\n") { it.getValues().toString() }
        return "$rowsStr\n\n$columnsStr"
    }
}
