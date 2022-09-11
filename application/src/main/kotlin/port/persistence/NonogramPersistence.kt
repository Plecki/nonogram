package port.persistence

import domain.BoardWithState
import domain.state.BoardState

interface NonogramPersistence {

    fun persist(boardWithState: BoardWithState)

    fun getActiveBoard(): BoardWithState

    fun updateCurrentState(updatedBoard: BoardState)

}