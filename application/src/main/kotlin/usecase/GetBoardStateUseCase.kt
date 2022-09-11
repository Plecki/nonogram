package usecase

import domain.state.BoardState

fun interface GetBoardStateUseCase {

    fun getBoardState(): BoardState

}