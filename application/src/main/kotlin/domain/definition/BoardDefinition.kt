package domain.definition

data class BoardDefinition(
    val rows: List<LineDefinition>,
    val columns: List<LineDefinition>,
) {

    override fun toString(): String {
        val rowsStr = rows.joinToString(separator = "\n") { it.values.toString() }
        val columnsStr = columns.joinToString(separator = "\n") { it.values.toString() }
        return "$rowsStr\n\n$columnsStr"
    }
}
