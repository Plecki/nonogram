package port.persistence

import domain.model.BoardWithState
import domain.model.state.BoardState

interface NonogramPersistence {

    fun persist(boardWithState: BoardWithState)

    fun getActiveBoard(): BoardWithState

    fun updateCurrentState(updatedBoard: BoardState)

}