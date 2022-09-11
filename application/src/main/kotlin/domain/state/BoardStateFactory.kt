package domain.state

import domain.definition.BoardDefinition

interface BoardStateFactory {

    fun createEmpty(boardDefinition: BoardDefinition): BoardState

}
