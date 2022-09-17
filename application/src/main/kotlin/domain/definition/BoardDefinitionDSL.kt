package domain.definition


fun boardDefinition(howToBuild: BoardDefinitionBuilder.() -> Unit): BoardDefinition {
    val builder = BoardDefinitionBuilder()
    howToBuild(builder)
    return builder.build()
}

fun row(howToBuild: LineDefinitionBuilder.() -> Unit): RowDefinition {
    val builder = LineDefinitionBuilder()
    howToBuild(builder)
    return RowDefinition(builder.build())
}

fun row(vararg values: Int): RowDefinition {
    return RowDefinition(LineDefinition(values.asList()))
}

fun column(howToBuild: LineDefinitionBuilder.() -> Unit): ColumnDefinition {
    val builder = LineDefinitionBuilder()
    howToBuild(builder)
    return ColumnDefinition(builder.build())
}

fun column(vararg values: Int): ColumnDefinition {
    return ColumnDefinition(LineDefinition(values.asList()))
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

class LineDefinitionBuilder {
    lateinit var values: List<Int>

    fun build(): LineDefinition {
        return LineDefinition(values)
    }
}

@JvmInline
value class RowDefinition(val lineDefinition: LineDefinition)

@JvmInline
value class ColumnDefinition(val lineDefinition: LineDefinition)
