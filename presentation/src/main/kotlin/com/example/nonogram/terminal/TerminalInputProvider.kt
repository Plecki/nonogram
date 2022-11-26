package com.example.nonogram.terminal

import domain.model.state.Input
import port.presentation.NonogramInput

class TerminalInputProvider : NonogramInput {

    override fun provideInput(): Input {
        val inputString = readLine()!!
        val (rowIndex, colIndex) = inputString.split(" ")
        return Input(rowIndex.toInt(), colIndex.toInt())
    }
}
