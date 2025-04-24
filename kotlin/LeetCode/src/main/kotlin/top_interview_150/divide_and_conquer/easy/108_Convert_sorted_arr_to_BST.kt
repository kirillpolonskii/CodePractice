package top_interview_150.divide_and_conquer.easy

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int) {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return recursiveTransformation(nums)
    }

    private fun recursiveTransformation(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        val curRoot = TreeNode(nums[nums.size / 2])
        if (nums.size > 1) {
            curRoot.left = recursiveTransformation(nums.copyOfRange(0, nums.size / 2))
            curRoot.right = recursiveTransformation(nums.copyOfRange(nums.size / 2 + 1, nums.size))
        }
        return curRoot
    }    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {

}