package usecase

import domain.model.BoardWithState

interface NonogramGame {

    fun playGame(boardWithState: BoardWithState)

}
