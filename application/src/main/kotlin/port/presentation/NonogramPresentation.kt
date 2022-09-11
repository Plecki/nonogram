package port.presentation

import domain.BoardWithState

interface NonogramPresentation {

    fun present(boardWithState: BoardWithState)

}