import domain.model.definition.LineDefinition

class LineDefinitionConverter {
    fun convert(lines: List<String>, maxLineSize: Int? = null): List<LineDefinition> {
        if (lines.count { it.isBlank() } > 0)
            throw IllegalArgumentException("There are blank lines")

        return lines.map { convert(it, maxLineSize) }
    }

    fun convert(line: String, maxLineSize: Int? = null): LineDefinition {
        val values = line
            .split(Regex("\\s"))
            .map { it.toInt() }
        return LineDefinition(values, maxLineSize)
    }
}
