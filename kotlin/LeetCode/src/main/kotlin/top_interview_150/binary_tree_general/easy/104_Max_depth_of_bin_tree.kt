package top_interview_150.binary_tree_general.easy

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
    var maxDepthVal = 0
    fun maxDepth(root: TreeNode?): Int {
        if (root != null)
            recursNLR(root, 1)
        return maxDepthVal
    }

    fun recursNLR(curNode: TreeNode?, curDepth: Int){ // node-left-right traverse
        if (curNode != null) {
            maxDepthVal = kotlin.math.max(maxDepthVal, curDepth)
            if (curNode.left != null) recursNLR(curNode.left, curDepth + 1)
            if (curNode.right != null) recursNLR(curNode.right, curDepth + 1)
        }

    }
}