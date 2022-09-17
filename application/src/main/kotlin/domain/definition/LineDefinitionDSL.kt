package domain.definition

class LineDefinitionBuilder {
    lateinit var values: List<Int>

    fun build(): LineDefinition {
        return LineDefinition(values)
    }
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

@JvmInline
value class RowDefinition(val lineDefinition: LineDefinition)

@JvmInline
value class ColumnDefinition(val lineDefinition: LineDefinition)