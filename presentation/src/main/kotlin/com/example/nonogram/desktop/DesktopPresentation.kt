package com.example.nonogram.desktop

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import domain.BoardDefinition
import domain.LineDefinition
import port.presentation.NonogramPresentation

class DesktopPresentation : NonogramPresentation {
    private lateinit var nonogramWindowState: NonogramWindowState

    override fun present(nonogram: BoardDefinition) {
        createWindow()
        println("window created")
    }

    @Preview
    private fun createWindow() {
        application {
            window(::exitApplication)
            nonogramWindowState = NonogramWindowState()
            createApplicationHandles()
        }
    }

    @Preview
    @Composable
    private fun window(onExit: () -> Unit) {
        Window(
            onCloseRequest = onExit,
            title = "Nonogram",
            state = rememberWindowState(width = 300.dp, height = 300.dp)
        ) {
            createWindowScope()
        }
    }

    @Composable
    fun Board(boardDefinition: BoardDefinition) {
        Column {
            Row {
                sampleCard()
                showColumnDefinitions(boardDefinition.getColumns())
            }
            Row {
                showRowDefinitions(boardDefinition.getRows())
                sampleCard()
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
                    items(columnDefinitions[colIndex].getValues()) { columnDefinitionValue ->
                        cell(columnDefinitionValue)
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
                    items(rowDefinitions[rowIndex].getValues()) { rowDefinitionValue ->
                        cell(rowDefinitionValue)
                    }
                }
            }
        }
    }

    @Composable
    private fun cell(value: Int?) {
        Card(backgroundColor = Color.LightGray) {
            Text("$value")
        }
    }

    @Composable
    private fun createWindowScope() {
        Board(nonogramWindowState.boardDefinition)
    }

    private fun createApplicationHandles() {
        nonogramWindowState.initialize()
    }
}