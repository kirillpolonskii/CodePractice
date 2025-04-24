package top_interview_150.binary_search.easy

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var lBound = 0
        var rBound = nums.size - 1
        var curInd = 0
        var found = false
        while (rBound > lBound) {
            println("$lBound $rBound")
            curInd = (rBound + lBound) / 2
            if (nums[curInd] == target) {
                found = true
                break
            }
            else if (target < nums[curInd]) {
                rBound = curInd - 1
            }
            else {
                lBound = curInd + 1
            }
            println("$lBound $rBound")
        }
        if (found) return curInd
        when {
            lBound == rBound -> {
                if (nums[lBound] == target) curInd = lBound
                else if (target < nums[lBound]) curInd = lBound
                else curInd = rBound + 1
            }
            else -> {
                curInd = lBound
            }

        }
        return curInd
    }
}
fun main(){
    println(Solution().searchInsert(
        intArrayOf(1, 3, 5, 7, 9, 11, 13, 15),
        16))
}