package com.example.nonogram.terminal

import domain.model.BoardWithState
import domain.model.state.BoardState
import domain.model.state.CellPosition
import domain.model.state.CellState
import usecase.NonogramGame
import usecase.UpdateCellStateUseCase

class TerminalGame(
    private val terminalPresentation: TerminalPresentation,
    private val terminalInputProvider: TerminalInputProvider,
    private val updateCellStateUseCase: UpdateCellStateUseCase,
) : NonogramGame {
    private lateinit var boardWithState: BoardWithState

    override fun playGame(boardWithState: BoardWithState) {
        this.boardWithState = boardWithState

        while (true) {
            terminalPresentation.present(this.boardWithState)
            val nextBoardState = nextBoardState()
            this.boardWithState = BoardWithState(boardWithState.boardDefinition, nextBoardState)
        }
    }

    private fun nextBoardState(): BoardState {
        val input = terminalInputProvider.provideInput()
        return updateCellStateUseCase.updateWith(CellPosition(input.rowIndex, input.columnIndex), CellState(true))
    }
}