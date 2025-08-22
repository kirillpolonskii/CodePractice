package top_interview_150.dp_multid.medium

import kotlin.math.min

class Solution120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.size == 1) return triangle[0][0]
        var prevLayer = IntArray(triangle[triangle.size - 2].size)
        val curLayer = IntArray(triangle[triangle.size - 1].size)
        prevLayer[0] = triangle[0][0]
        for (i in 1..<triangle.size){
            curLayer[0] = triangle[i][0] + prevLayer[0]
            for (j in 1..<triangle[i].size - 1){
                curLayer[j] =
                    min(
                        triangle[i][j] + prevLayer[j - 1],
                        triangle[i][j] + prevLayer[j])

            }
            curLayer[triangle[i].size - 1] = triangle[i].last() + prevLayer[triangle[i - 1].size - 1]
            prevLayer = curLayer.clone()
        }
        return curLayer.min()
    }
}

fun main(){
    println(Solution120().minimumTotal(listOf(
        listOf(2),
        listOf(3,4),
        listOf(6,5,7),
        listOf(4,1,8,3)
    )))
}