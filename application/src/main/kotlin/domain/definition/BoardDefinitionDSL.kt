package domain.definition


fun boardDefinition(howToBuild: BoardDefinitionBuilder.() -> Unit): BoardDefinition {
    val builder = BoardDefinitionBuilder()
    howToBuild(builder)
    return builder.build()
}

fun row(howToBuild: LineDefinitionBuilder.() -> Unit): LineDefinition {
    val builder = LineDefinitionBuilder()
    howToBuild(builder)
    return builder.build()
}

fun column(howToBuild: LineDefinitionBuilder.() -> Unit): LineDefinition =
    row(howToBuild)

class BoardDefinitionBuilder {
    val rows: MutableList<LineDefinition> = mutableListOf()
    val columns: MutableList<LineDefinition> = mutableListOf()

    fun build(): BoardDefinition {
        return BoardDefinition(rows, columns)
    }

    // FIXME plus adds to rows, minus adds to columns
    operator fun LineDefinition.unaryPlus() {
        rows.add(this)
    }

    operator fun LineDefinition.unaryMinus() {
        columns.add(this)
    }
}

class LineDefinitionBuilder {
    lateinit var values: List<Int>

    fun build(): LineDefinition {
        return LineDefinition(values)
    }
}
