package com.example.nonogram.desktop

import domain.model.BoardWithState
import usecase.NonogramGame

class DesktopGame(
    private val desktopPresentation: DesktopPresentation,
) : NonogramGame {

    override fun playGame(boardWithState: BoardWithState) {
        desktopPresentation.present(boardWithState)
    }
}