package top_interview_150.two_pointers.medium

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var leftSideInd = 0
        var rightSideInd = height.size - 1
        var maxArea = kotlin.math.min(height[leftSideInd], height[rightSideInd]) * (height.size - 1)
        while (leftSideInd < rightSideInd){
            if (height[leftSideInd] < height[rightSideInd]){
                ++leftSideInd
            }
            else {
                --rightSideInd
            }
            maxArea = kotlin.math.max(
                maxArea,
                kotlin.math.min(height[leftSideInd], height[rightSideInd]) * (rightSideInd - leftSideInd))
        }

        return maxArea
    }
}