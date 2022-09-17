package usecase

import domain.model.definition.BoardDefinition

fun interface GetBoardUseCase {

    fun getBoard(): BoardDefinition

}
