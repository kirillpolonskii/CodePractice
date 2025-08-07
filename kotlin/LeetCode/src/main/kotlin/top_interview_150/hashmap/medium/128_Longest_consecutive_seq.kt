package top_interview_150.hashmap.medium

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val elems = hashSetOf<Int>()
        for (i in 0..<nums.size){
            elems.add(nums[i])
        }
        var maxLength = 0
        var seqToLeft = 0
        var seqToRight = 0
        for (i in nums.indices){
            val point = nums[i]
            if (!elems.contains(point)) continue
            var curToLeft = point - 1
            var curToRight = point + 1
            while (elems.contains(curToLeft)){
                ++seqToLeft
                elems.remove(curToLeft)
                --curToLeft
            }
            while (elems.contains(curToRight)){
                ++seqToRight
                elems.remove(curToRight)
                ++curToRight
            }
            elems.remove(point)
            maxLength = kotlin.math.max(maxLength, seqToLeft + 1 + seqToRight)
            seqToLeft = 0
            seqToRight = 0
        }
        return maxLength
    }
}