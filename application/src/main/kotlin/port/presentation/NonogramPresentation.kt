package port.presentation

import domain.definition.BoardDefinition

interface NonogramPresentation {

    fun present(nonogram: BoardDefinition)

}