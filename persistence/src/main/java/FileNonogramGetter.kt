import domain.Board
import port.persistence.NonogramGetter

class FileNonogramGetter : NonogramGetter {
    override fun getNonogram(): Board {
        // TODO
        println("Getting a board")
        return Board()
    }
}