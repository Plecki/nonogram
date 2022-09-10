import domain.BoardDefinition
import port.persistence.NonogramGetter
import java.io.File
import java.io.FileReader

class FileNonogramGetter(
    private val file: File,
    private val boardDefinitionConverter: BoardDefinitionConverter
) : NonogramGetter {

    constructor(resourcesFileName: String, boardDefinitionConverter: BoardDefinitionConverter)
            : this(
        File(FileNonogramGetter::class.java.classLoader.getResource(resourcesFileName).toURI()),
        boardDefinitionConverter
    )

    override fun getNonogram(): BoardDefinition {
        val lines = FileReader(file).readLines()
        return boardDefinitionConverter.convert(lines)
    }
}