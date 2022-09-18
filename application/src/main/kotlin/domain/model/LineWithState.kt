package domain.model

import domain.model.definition.LineDefinition
import domain.model.state.LineState

data class LineWithState(
    val lineDefinition: LineDefinition,
    val lineState: LineState,
    val lineSize: Int,
) {
    fun isSolved(): Boolean {
        // TODO
        return lineDefinition.values.sum() == lineState.cellStates.count { it.state }
    }
}