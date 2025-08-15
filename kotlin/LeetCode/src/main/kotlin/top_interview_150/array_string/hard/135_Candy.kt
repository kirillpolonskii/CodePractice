package top_interview_150.array_string.hard

class Solution135 {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        val candies = IntArray(n) { 1 }
        for (i in 0..<n) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            }
            println(candies.joinToString())
        }
        for (i in n-1 downTo 0) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                candies[i] = kotlin.math.max(candies[i], candies[i + 1] + 1)
            }
            println(candies.joinToString())
        }
        return candies.sum()
    }
}

fun main(){
    println(Solution135().candy(intArrayOf(3,2,1,1,4,3,3)))
}