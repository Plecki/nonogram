package domain.model.definition


fun boardDefinition(howToBuild: BoardDefinitionBuilder.() -> Unit): BoardDefinition {
    val builder = BoardDefinitionBuilder()
    howToBuild(builder)
    return builder.build()
}

class BoardDefinitionBuilder {
    val rows: MutableList<LineDefinition> = mutableListOf()
    val columns: MutableList<LineDefinition> = mutableListOf()

    fun build(): BoardDefinition {
        return BoardDefinition(rows, columns)
    }

    operator fun RowDefinition.unaryPlus() {
        rows.add(this.lineDefinition)
    }

    operator fun ColumnDefinition.unaryPlus() {
        columns.add(this.lineDefinition)
    }
}
