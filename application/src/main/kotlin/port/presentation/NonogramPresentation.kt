package port.presentation

import domain.model.BoardWithState

interface NonogramPresentation {

    fun present(boardWithState: BoardWithState)

}