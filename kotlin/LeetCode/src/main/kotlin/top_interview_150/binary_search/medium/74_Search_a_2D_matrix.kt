package top_interview_150.binary_search.medium

class Solution74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.size == 1) return matrix[0].binarySearch(target) >= 0
        var lRow = 0
        var rRow = matrix.size - 1
        var potentialRow = (lRow + rRow) / 2
        while (lRow < rRow){
            if (target < matrix[potentialRow][0]){
                rRow = potentialRow - 1
            }
            else if (target > matrix[potentialRow][matrix[0].size - 1]){
                lRow = potentialRow + 1
            }
            else {
                break
            }
            if (lRow >= matrix.size || rRow < 0) return false
            potentialRow = (lRow + rRow) / 2
        }
        val pos = matrix[potentialRow].binarySearch(target)
        return pos >= 0


    }
}

fun main(){
    println(Solution74().searchMatrix(arrayOf(
        intArrayOf(1),
        intArrayOf(3),
        intArrayOf(5)), 5))
}