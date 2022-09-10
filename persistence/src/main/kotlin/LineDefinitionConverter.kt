import domain.LineDefinition
import org.springframework.stereotype.Service

@Service
class LineDefinitionConverter {
    fun convert(lines: List<String>): List<LineDefinition> {
        if (lines.count { it.isBlank() } > 0)
            throw IllegalArgumentException("There are blank lines")

        return lines.map { convert(it) }
    }

    fun convert(line: String): LineDefinition {
        val values = line
            .split(Regex("\\s"))
            .map { it.toInt() }
        return LineDefinition(values)
    }
}
