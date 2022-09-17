package com.example.nonogram.desktop

import domain.model.definition.BoardDefinition
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import usecase.GetBoardUseCase

class NonogramWindowState : KoinComponent {

    private val getBoardUseCase by inject<GetBoardUseCase>()

    lateinit var boardDefinition: BoardDefinition

    fun initialize() {
        boardDefinition = getBoardUseCase.getBoard()
    }

}
