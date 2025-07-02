package top_interview_150.matrix.medium

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val containedInRows = Array(9) { _ -> BooleanArray(9) }
        val containedInColumns = Array(9) { _ -> BooleanArray(9) }
        val containedInBoxes = Array(9) { _ -> BooleanArray(9) }
        for (i in 0..<9) {
            for (j in 0..<9) {
                if (board[i][j].isDigit()){
                    if (containedInRows[i][board[i][j].digitToInt() - 1] ||
                        containedInColumns[j][board[i][j].digitToInt() - 1] ||
                        containedInBoxes[(i / 3) * 3 + (j / 3)][board[i][j].digitToInt() - 1]){
                        return false
                    }
                    containedInRows[i][board[i][j].digitToInt() - 1] = true
                    containedInColumns[j][board[i][j].digitToInt() - 1] = true
                    containedInBoxes[(i / 3) * 3 + (j / 3)][board[i][j].digitToInt() - 1] = true
                }

            }
        }
        return true
    }
}
