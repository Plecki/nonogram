package usecase

import domain.BoardDefinition

interface GetBoardUseCase {

    fun getBoard(): BoardDefinition

}
