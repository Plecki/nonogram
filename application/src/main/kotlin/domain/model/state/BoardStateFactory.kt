package domain.model.state

import domain.model.definition.BoardDefinition

interface BoardStateFactory {

    fun createEmpty(boardDefinition: BoardDefinition): BoardState

}
