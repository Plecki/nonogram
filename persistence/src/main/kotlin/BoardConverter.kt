import domain.Board
import domain.Column
import domain.Row

class BoardConverter {
    fun convert(lines: List<String>): Board {
        if (lines.isEmpty())
            throw IllegalArgumentException("Board cannot be empty")

        return Board(listOf(Row()), listOf(Column()))
    }
}
