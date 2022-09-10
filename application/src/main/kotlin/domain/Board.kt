package domain

class Board constructor(
    private val rows: List<Row>,
    private val columns: List<Column>,
) {

    fun getRows(): List<Row> {
        return rows
    }

    fun getColumns(): List<Column> {
        return columns
    }

}
