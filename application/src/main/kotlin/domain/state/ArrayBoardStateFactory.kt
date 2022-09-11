package domain.state

import domain.definition.BoardDefinition

class ArrayBoardStateFactory : BoardStateFactory {
    override fun createEmpty(boardDefinition: BoardDefinition): BoardState {
        return ArrayBoardState.createEmpty(boardDefinition.rows.size, boardDefinition.columns.size)
    }
}