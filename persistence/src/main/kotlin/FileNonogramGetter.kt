import domain.BoardDefinition
import port.persistence.NonogramGetter

class FileNonogramGetter : NonogramGetter {
    override fun getNonogram(): BoardDefinition {
        // TODO
        println("Getting a board")
        return BoardDefinition(listOf(), listOf())
    }
}