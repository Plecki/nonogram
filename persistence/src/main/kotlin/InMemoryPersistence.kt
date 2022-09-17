import domain.model.BoardWithState
import domain.model.state.BoardState
import port.persistence.NonogramPersistence

class InMemoryPersistence : NonogramPersistence {

    private lateinit var boardWithState: BoardWithState

    override fun persist(boardWithState: BoardWithState) {
        this.boardWithState = boardWithState
    }

    override fun getActiveBoard(): BoardWithState {
        return boardWithState
    }

    override fun updateCurrentState(updatedBoard: BoardState) {
        boardWithState = boardWithState.copy(boardState = updatedBoard)
    }
}