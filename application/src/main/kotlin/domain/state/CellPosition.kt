package domain.state

@JvmInline
value class CellPosition(val position: Pair<Int, Int>) {

    constructor(row: Int, column: Int) : this(Pair(row, column))

    fun getColumn(): Int {
        return position.second
    }

    fun getRow(): Int {
        return position.first
    }
}
