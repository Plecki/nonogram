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

}
