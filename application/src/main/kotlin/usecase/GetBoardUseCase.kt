package usecase

import domain.definition.BoardDefinition

fun interface GetBoardUseCase {

    fun getBoard(): BoardDefinition

}
