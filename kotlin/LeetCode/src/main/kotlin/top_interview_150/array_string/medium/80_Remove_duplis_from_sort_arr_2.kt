package top_interview_150.array_string.medium

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 1) return 1
        var i = 0
        var curRepetNum = 0
        while (i < nums.size - 1){
            if (nums[i] == nums[i + 1]){
                curRepetNum = nums[i]
                i += 2
                while (i < nums.size && nums[i] == curRepetNum){
                    nums[i] = Int.MIN_VALUE
                    ++i
                }
            }
            else {
                ++i
            }
        }
        var k = 0
        var emptySlot = 0
        var firstNotEmpty = 0
        while (firstNotEmpty < nums.size && emptySlot < nums.size){
            while (emptySlot < nums.size && nums[emptySlot] != Int.MIN_VALUE){
                ++emptySlot
                ++k
            }
            if (emptySlot == nums.size) break
            firstNotEmpty = emptySlot + 1
            while (firstNotEmpty < nums.size && nums[firstNotEmpty] == Int.MIN_VALUE){
                ++firstNotEmpty
            }
            if (firstNotEmpty == nums.size) break
            nums[emptySlot] = nums[firstNotEmpty]
            nums[firstNotEmpty] = Int.MIN_VALUE
            ++k
            ++emptySlot
            ++firstNotEmpty
        }
        return k
    }
}

fun main(){
    println(Solution80().removeDuplicates(intArrayOf(0, 0, 0)))
}