package com.example.nonogram.desktop

import GetBoardUseCase
import domain.BoardDefinition
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NonogramWindowState : KoinComponent {

    private val getBoardUseCase by inject<GetBoardUseCase>()

    lateinit var boardDefinition: BoardDefinition

    fun initialize() {
        boardDefinition = getBoardUseCase.getBoard()
    }

}
