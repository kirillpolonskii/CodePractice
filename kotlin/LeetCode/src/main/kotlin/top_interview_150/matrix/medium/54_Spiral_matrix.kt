package top_interview_150.matrix.medium

class Solution54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val answer = mutableListOf<Int>()
        val size = matrix.size * matrix[0].size
        var upBorder = -1
        var rightBorder = matrix[0].size
        var bottomBorder = matrix.size
        var leftBorder = -1
        var curI = 0
        var curJ = 0
        while (true){
            while (curJ < rightBorder){
                answer.add(matrix[curI][curJ])
                println(matrix[curI][curJ])
                ++curJ
            }
            --curJ
            ++upBorder
            if (answer.size == size){
                break
            }
            ++curI
            while(curI < bottomBorder){
                answer.add(matrix[curI][curJ])
                println(matrix[curI][curJ])
                ++curI
            }
            --curI
            --rightBorder
            if (answer.size == size){
                break
            }
            --curJ
            while(curJ > leftBorder){
                answer.add(matrix[curI][curJ])
                println(matrix[curI][curJ])
                --curJ
            }
            ++curJ
            --bottomBorder
            if (answer.size == size){
                break
            }
            --curI
            while(curI > upBorder){
                answer.add(matrix[curI][curJ])
                println(matrix[curI][curJ])
                --curI
            }
            ++curI
            ++leftBorder
            if (answer.size == size){
                break
            }
            ++curJ
        }
        return answer
    }
}

fun main(){
    println(Solution54().spiralOrder(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))))
}