package top_interview_150.dp_1d.easy

class Solution {
    fun climbStairs(n: Int): Int {
        val stepsCount = IntArray(n + 1)
        stepsCount[0] = 0
        stepsCount[1] = 1
        if (n > 1)
            stepsCount[2] = 2
        for (i in 3..n){
            stepsCount[i] = stepsCount[i - 1] + stepsCount[i - 2]
        }
        return stepsCount[n]
    }
}