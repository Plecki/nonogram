package domain.model.definition

data class BoardDefinition(
    val rows: List<LineDefinition>,
    val columns: List<LineDefinition>,
) {
    init {
        require(rows.isNotEmpty())
        require(columns.isNotEmpty())
    }

    override fun toString(): String {
        val rowsStr = rows.joinToString(separator = "\n") { it.values.toString() }
        val columnsStr = columns.joinToString(separator = "\n") { it.values.toString() }
        return "$rowsStr\n\n$columnsStr"
    }

    fun numberOfColumns(): Int = columns.size

    fun numberOfRows(): Int = rows.size
}
