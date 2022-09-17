package com.example.nonogram.desktop

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import domain.model.BoardWithState
import domain.model.definition.BoardDefinition
import domain.model.definition.LineDefinition
import domain.model.state.BoardState
import domain.model.state.CellPosition
import domain.model.state.CellState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import port.presentation.NonogramPresentation
import usecase.UpdateCellStateUseCase

class DesktopPresentation : NonogramPresentation, KoinComponent {

    private val updateCellStateUseCase by inject<UpdateCellStateUseCase>()

    private lateinit var boardState: MutableState<BoardState>

    override fun present(boardWithState: BoardWithState) {
        createWindow(boardWithState)
        println("window created")
    }

    @Preview
    private fun createWindow(boardWithState: BoardWithState) {
        application {
            window(::exitApplication, boardWithState)
        }
    }

    @Preview
    @Composable
    private fun window(onExit: () -> Unit, boardWithState: BoardWithState) {
        Window(
            onCloseRequest = onExit,
            title = "Nonogram",
            state = rememberWindowState(width = 600.dp, height = 400.dp),
        ) {
            createWindowScope(boardWithState)
        }
    }

    @Composable
    fun Board(boardDefinition: BoardDefinition, boardState: MutableState<BoardState>) {
        Column {
            Row {
                sampleCard()
                showColumnDefinitions(boardDefinition.columns)
            }
            Row {
                showRowDefinitions(boardDefinition.rows)
                showNonogramGrid(boardState, boardDefinition.columns.size, boardDefinition.rows.size)
            }
        }
    }

    @Composable
    private fun sampleCard() {
        Card(backgroundColor = Color.Blue) {
            Text("Something")
        }
    }

    @Composable
    private fun showColumnDefinitions(columnDefinitions: List<LineDefinition>) {
        LazyRow(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            items(columnDefinitions.size) { colIndex ->
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                ) {
                    items(columnDefinitions[colIndex].values) { columnDefinitionValue ->
                        definitionValueCell(columnDefinitionValue)
                    }
                }
            }
        }
    }

    @Composable
    private fun showRowDefinitions(rowDefinitions: List<LineDefinition>) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.End,
        ) {
            items(rowDefinitions.size) { rowIndex ->
                LazyRow(
                    modifier = Modifier.padding(16.dp),
                ) {
                    items(rowDefinitions[rowIndex].values) { rowDefinitionValue ->
                        definitionValueCell(rowDefinitionValue)
                    }
                }
            }
        }
    }

    @Composable
    private fun definitionValueCell(value: Int?) {
        Card(backgroundColor = Color.LightGray) {
            Text("$value")
        }
    }

    @Composable
    private fun showNonogramGrid(boardState: MutableState<BoardState>, columnSize: Int, rowsSize: Int) {
        LazyRow(
            modifier = Modifier.padding(16.dp),
        ) {
            items(columnSize) { columnIndex ->
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                ) {
                    items(rowsSize) { rowIndex ->
                        nonogramCell(boardState.value.getStateOf(rowIndex, columnIndex), rowIndex, columnIndex)
                    }
                }
            }
        }
    }

    @Composable
    private fun nonogramCell(cellState: CellState, rowIndex: Int, columnIndex: Int) {
        Button(
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = if (cellState.state) Color.Green else Color.Red),
            onClick = { cellClicked(rowIndex, columnIndex) },
        ) {
            Text("($rowIndex,$columnIndex)")
        }
    }

    @Composable
    private fun createWindowScope(boardWithState: BoardWithState) {
        boardState = remember { mutableStateOf(boardWithState.boardState) }
        Board(boardWithState.boardDefinition, boardState)
    }

    private fun cellClicked(rowIndex: Int, columnIndex: Int) {
        val newBoardState = updateCellStateUseCase.updateWith(CellPosition(rowIndex, columnIndex), CellState(true))
        boardState.value = newBoardState
    }
}