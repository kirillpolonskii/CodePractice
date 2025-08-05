package top_interview_150.binary_tree_general.medium

class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
}

class Solution129 {
    var totalSum = 0

    fun sumNumbers(root: TreeNode?): Int {
        traverse(root!!, 0)
        return totalSum
    }

    fun traverse(curNode: TreeNode, prevNum: Int){
        if (curNode.left == null && curNode.right == null){ // in a leaf
            val curNum = prevNum * 10 + curNode.`val`
            totalSum += curNum
        }
        else {
            val curNum = prevNum * 10 + curNode.`val`
            if (curNode.left != null){
                traverse(curNode.left!!, curNum)
            }
            if (curNode.right != null){
                traverse(curNode.right!!, curNum)
            }
        }
    }
}