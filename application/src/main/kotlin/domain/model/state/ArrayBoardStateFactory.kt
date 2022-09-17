package domain.model.state

import domain.model.definition.BoardDefinition

class ArrayBoardStateFactory : BoardStateFactory {
    override fun createEmpty(boardDefinition: BoardDefinition): BoardState {
        return ArrayBoardState.createEmpty(boardDefinition.rows.size, boardDefinition.columns.size)
    }
}