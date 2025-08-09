package top_interview_150.array_string.medium

class Solution55 {
    fun canJump(nums: IntArray): Boolean {
        val reaching = BooleanArray(nums.size)
        reaching[nums.size - 1] = true
        for (i in nums.size - 2 downTo 0){
            for (j in kotlin.math.min(nums.size - 1, i + nums[i]) downTo i){
                if (reaching[j]) reaching[i] = true
            }
        }
        return reaching[0]
    }
}