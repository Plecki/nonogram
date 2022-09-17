package usecase

import domain.model.state.BoardState

fun interface GetBoardStateUseCase {

    fun getBoardState(): BoardState

}