package tans_interview_150.two_pointers.medium

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            val target = -nums[i]
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val currentSum = nums[left] + nums[right]
                if (currentSum == target) {
                    ans.add(listOf(nums[i], nums[left], nums[right]))
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--
                    left++
                    right--
                } else if (currentSum < target) {
                    left++
                } else {
                    right--
                }
            }
        }
        return ans
    }
}