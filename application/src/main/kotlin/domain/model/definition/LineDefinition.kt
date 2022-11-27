package domain.model.definition

data class LineDefinition(
    val values: List<Int>,
    val maxLineSize: Int? = null
) {

    constructor(vararg values: Int, maxLineSize: Int? = null) : this(values.toList(), maxLineSize)

    init {
        if (maxLineSize != null) {
            require(calculateMinLineSize(values) <= maxLineSize)
        }
    }

    private fun calculateMinLineSize(values: List<Int>) = values.sum() + values.size - 1
}
