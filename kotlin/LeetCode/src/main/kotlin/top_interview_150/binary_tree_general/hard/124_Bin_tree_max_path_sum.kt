package top_interview_150.binary_tree_general.hard

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
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {
    var globalMaxSum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        if (root!!.left == null && root.right == null) return root.`val`
        maxSumThroughNodes(root)
        return globalMaxSum
    }

    fun maxSumThroughNodes(curNode: TreeNode?): Int{
        if (curNode!!.left == null && curNode.right == null){
            globalMaxSum = kotlin.math.max(globalMaxSum, curNode.`val`)// in a leaf
            return curNode.`val`
        }
        else {
            val maxPathFromLeft = if (curNode.left != null) maxSumThroughNodes(curNode.left) else 0
            val maxPathFromRight = if (curNode.right != null) maxSumThroughNodes(curNode.right) else 0
            val localMaxSum = kotlin.math.max(
                curNode.`val`,
                kotlin.math.max(
                    maxPathFromLeft + curNode.`val`,
                    maxPathFromRight + curNode.`val`))
            globalMaxSum = kotlin.math.max(
                globalMaxSum,
                kotlin.math.max(
                    localMaxSum,
                    maxPathFromLeft + curNode.`val` + maxPathFromRight))
            return localMaxSum
        }
    }
}