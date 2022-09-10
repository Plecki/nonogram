package com.example.nonogram.desktop

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import domain.BoardDefinition
import port.presentation.NonogramPresentation

class DesktopPresentation : NonogramPresentation {
    override fun present(nonogram: BoardDefinition) {
        application {
            Window(
                onCloseRequest = ::exitApplication,
                title = "Compose for Desktop",
                state = rememberWindowState(width = 300.dp, height = 300.dp)
            ) {
//                val count = remember { mutableStateOf(0) }
//                MaterialTheme {
//                    Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
//                        Button(modifier = Modifier.align(Alignment.CenterHorizontally),
//                            onClick = {
//                                count.value++
//                            }) {
//                            Text(if (count.value == 0) "Hello World" else "Clicked ${count.value}!")
//                        }
//                        Button(modifier = Modifier.align(Alignment.CenterHorizontally),
//                            onClick = {
//                                count.value = 0
//                            }) {
//                            Text("Reset")
//                        }
//                    }
//                }
            }
        }
    }
}