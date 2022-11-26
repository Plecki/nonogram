
import domain.model.definition.BoardDefinition
import port.persistence.NonogramGetter
import java.io.File
import java.io.FileReader

class FileNonogramGetter(
    private val file: File,
    private val boardDefinitionConverter: BoardDefinitionConverter
) : NonogramGetter {

    override fun getNonogram(): BoardDefinition {
        val lines = FileReader(file).readLines()
        return boardDefinitionConverter.convert(lines)
    }
}