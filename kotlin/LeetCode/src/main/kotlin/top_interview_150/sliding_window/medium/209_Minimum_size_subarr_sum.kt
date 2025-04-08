package top_interview_150.sliding_window.medium

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var winSt = 0
        var winEnd = 0
        var curSum = nums[winSt]
        var curLength = 1
        var minLength = Int.MAX_VALUE
        if (curSum >= target)
            minLength = kotlin.math.min(minLength, curLength)
        while (winEnd < nums.size - 1){
            //println("$winSt, $winEnd, $curSum")
            if (curSum - nums[winSt] >= target){
                curSum -= nums[winSt]
                ++winSt
                --curLength
            }
            else {
                ++winEnd
                curSum += nums[winEnd]
                ++curLength
            }
            if (curSum >= target)
                minLength = kotlin.math.min(minLength, curLength)
        }
        while (curSum - nums[winSt] >= target){
            //println("-$winSt, $winEnd, $curSum")
            ++winSt
            --curLength
            curSum -= nums[winSt - 1]
            minLength = kotlin.math.min(minLength, curLength)
        }
        if (curSum >= target){
            return minLength
        }
        else {
            return 0
        }
    }
}

fun main(){
    println(Solution().minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
    println(Solution().minSubArrayLen(4, intArrayOf(1,4,2)))
    println(Solution().minSubArrayLen(4, intArrayOf(1,1,1,1,1,1,1,1)))
    println(Solution().minSubArrayLen(11, intArrayOf(11, 11, 11, 11)))
}