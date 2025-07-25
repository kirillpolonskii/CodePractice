package top_interview_150.array_string.easy

private class Solution {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val ans = IntArray(n + m)
        var curNums1Ind = 0
        var curNums2Ind = 0
        for (i in 0..<m + n){
            if (curNums1Ind < m && curNums2Ind < n){
                ans[i] = if (nums1[curNums1Ind] < nums2[curNums2Ind]){
                    nums1[curNums1Ind++]
                }
                else {
                    nums2[curNums2Ind++]
                }
            }
            else if (curNums1Ind < m){
                ans[i] = nums1[curNums1Ind++]
            }
            else if (curNums2Ind < n){
                ans[i] = nums2[curNums2Ind++]
            }
        }
        for (i in 0..<m+n) nums1[i] = ans[i]
        println(nums1.joinToString())
    }
}
fun main(){
    val solution = Solution().merge(intArrayOf(0), 0, intArrayOf(1), 1)
}
