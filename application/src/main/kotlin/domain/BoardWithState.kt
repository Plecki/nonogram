package domain

import domain.definition.BoardDefinition
import domain.state.BoardState

data class BoardWithState(
    val boardDefinition: BoardDefinition,
    val boardState: BoardState,
)
