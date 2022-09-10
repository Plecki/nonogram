class RowColSplitter {
    fun splitRowsAndCols(lines: List<String>): Pair<List<String>, List<String>> {
        val indexOfLastNotBlankLine = lines.indexOfLast { it.isNotBlank() }
        val linesTrimmedOfTrailingBlankLines = lines.subList(0, indexOfLastNotBlankLine + 1)

        return splitRowsAndColsWithoutTrailingBlankLines(linesTrimmedOfTrailingBlankLines)
    }

    private fun splitRowsAndColsWithoutTrailingBlankLines(lines: List<String>): Pair<List<String>, List<String>> {
        val lineOfSplit = lines.indexOfFirst { it.isBlank() }
        if (lineOfSplit == -1)
            throw IllegalArgumentException("Cannot convert to rows and columns, there is no split line between them")

        if (lines.count { it.isBlank() } > 1)
            throw IllegalArgumentException("Cannot convert to rows and columns, there is no split line between them")

        val rows = lines.subList(0, lineOfSplit)
        val columns = lines.subList(lineOfSplit + 1, lines.size)

        if (rows.isEmpty())
            throw IllegalArgumentException("Rows cannot be empty")

        if (columns.isEmpty())
            throw IllegalArgumentException("Columns cannot be empty")

        return Pair(rows, columns)
    }
}