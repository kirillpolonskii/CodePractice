package top_interview_150.intervals.easy

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()){
            return emptyList<String>()
        }
        val ranges = mutableListOf<String>()
        var curRangeStartInd = 0
        var curRangeEndInd = 1
        while (curRangeEndInd < nums.size){
            if (nums[curRangeEndInd - 1] == nums[curRangeEndInd] - 1){
                ++curRangeEndInd
            }
            else{
                ranges.add(
                    if (curRangeEndInd == curRangeStartInd + 1){
                        nums[curRangeStartInd].toString()
                    }
                    else{
                        "${nums[curRangeStartInd]}->${nums[curRangeEndInd - 1]}"
                    }
                )
                curRangeStartInd = curRangeEndInd
                ++curRangeEndInd
            }
        }
        ranges.add(
            if (curRangeEndInd == curRangeStartInd + 1){
                nums[curRangeStartInd].toString()
            }
            else{
                "${nums[curRangeStartInd]}->${nums[curRangeEndInd - 1]}"
            }
        )
        return ranges.toList()
    }
}

fun main(){
    println(Solution().summaryRanges(intArrayOf()))
}