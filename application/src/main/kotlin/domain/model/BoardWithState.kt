package domain.model

import domain.model.definition.BoardDefinition
import domain.model.state.BoardState

data class BoardWithState(
    val boardDefinition: BoardDefinition,
    val boardState: BoardState,
)
