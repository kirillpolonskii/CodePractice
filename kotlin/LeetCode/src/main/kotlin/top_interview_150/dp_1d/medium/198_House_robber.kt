package top_interview_150.dp_1d.medium

class Solution198 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return kotlin.math.max(nums.first(), nums.last())
        if (nums.size == 3) return kotlin.math.max(nums[nums.size - 2], nums.first() + nums.last())
        nums[2] += nums[0]
        for (i in 3..<nums.size){
            nums[i] = nums[i] + kotlin.math.max(nums[i - 2], nums[i - 3])
        }
        return kotlin.math.max(nums.last(), nums[nums.size - 2])
    }
}