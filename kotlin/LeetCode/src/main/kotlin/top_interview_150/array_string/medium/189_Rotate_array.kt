package top_interview_150.array_string.medium

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var lastRewritten = nums.last()
        for (i in 1..k){
            for (i in nums.size-1 downTo 1){
                nums[i] = nums[i - 1]
            }
            nums[0] = lastRewritten
            lastRewritten = nums.last()
        }
    }
}