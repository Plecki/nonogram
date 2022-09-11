package usecase

import domain.definition.BoardDefinition

interface GetBoardUseCase {

    fun getBoard(): BoardDefinition

}
