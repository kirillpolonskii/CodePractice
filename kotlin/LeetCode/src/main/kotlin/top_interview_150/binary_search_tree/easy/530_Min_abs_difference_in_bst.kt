package top_interview_150.binary_search_tree.easy

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
    val treeAsList = mutableListOf<Int>()
    fun getMinimumDifference(root: TreeNode?): Int {
        populateList(root)
        println(treeAsList.joinToString())
        var minDiff = Int.MAX_VALUE
        for (i in 0..treeAsList.size - 2){
            minDiff = kotlin.math.min(minDiff, kotlin.math.abs(treeAsList[i] - treeAsList[i + 1]))
        }
        return minDiff
    }

    fun populateList(root: TreeNode?) {
        if (root != null){
            populateList(root.left)
            treeAsList.add(root.`val`)
            populateList(root.right)
        }
    }
}

fun main(){
    val root = TreeNode(1)
    root.left = null
    root.right = TreeNode(3)
    root.right!!.left = TreeNode(2)
    println(Solution().getMinimumDifference(
        root
    ))
}