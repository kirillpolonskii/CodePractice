package top_interview_150.array_string.medium
/*
* Решение за O(n):
* if (nums.size <= 1) return 0

    var jumps = 0
    var currentEnd = 0
    var farthest = 0

    for (i in 0 until nums.size - 1) {
        farthest = maxOf(farthest, i + nums[i])
        if (i == currentEnd) {
            jumps++
            currentEnd = farthest
            if (currentEnd >= nums.size - 1) break
        }
    }

    return jumps
* */
class Solution45 {
    fun jump(nums: IntArray): Int {
        if (nums.size == 1) return 0
        val n = nums.size
        val minSteps = IntArray(n)
        for (i in 0..<n){
            if (i + nums[i] >= n - 1){
                minSteps[n - 1] = minSteps[i] + 1
                break
            }
            else {
                for (j in 1..nums[i]){
                    if (minSteps[i + j] == 0){
                        minSteps[i + j] = minSteps[i] + 1
                    }
                    else {
                        minSteps[i + j] = kotlin.math.min(minSteps[i + j],
                            minSteps[i] + 1)
                    }
                }
            }
        }
        return minSteps[n - 1]
    }
}
fun main(){
    println(Solution45().jump(intArrayOf(1, 1, 3, 1, 1, 1)))
}