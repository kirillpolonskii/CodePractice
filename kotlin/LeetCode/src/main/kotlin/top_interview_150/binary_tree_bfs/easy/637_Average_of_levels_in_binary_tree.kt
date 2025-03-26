package top_interview_150.binary_tree_bfs.easy

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
class TreeNode(var el: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
class Solution {
    var sumOnLevel = mutableListOf<Long>()
    var amountOnLevel = mutableListOf<Int>()
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val maxDepth = maxTreeDepth(root!!)
        (0..<maxDepth).forEach { sumOnLevel.add(0L) }
        (0..<maxDepth).forEach { amountOnLevel.add(0) }
        dfs(root, 0)
        val averOfLevels = sumOnLevel
            .zip(amountOnLevel)
            .map { it.first / it.second.toDouble() }
            .toDoubleArray()
        return averOfLevels
    }
    fun dfs(node: TreeNode, level: Int): Unit {
        sumOnLevel[level] += node.el.toLong()
        ++amountOnLevel[level]
        if (node.left != null){
            dfs(node.left!!, level + 1)
        }
        if (node.right != null){
            dfs(node.right!!, level + 1)
        }
    }
    fun maxTreeDepth(root: TreeNode): Int {
        var curMaxDepth = 0
        if (root.left != null){
            curMaxDepth = maxTreeDepth(root.left!!)
        }
        if (root.right != null){
            curMaxDepth = kotlin.math.max(curMaxDepth, maxTreeDepth(root.right!!))
        }
        return 1 + curMaxDepth
    }
    fun averageOfLevelsTest(tree: List<Int?>): DoubleArray {
        var curLevelStart = 0
        var curLevelEnd = 0
        var offset = 2
        val averOfLevels = mutableListOf<Double>()
        while (curLevelStart < tree.size){
            var curSum = 0
            var curAmount = 0
            for(i in curLevelStart..kotlin.math.min(curLevelEnd, tree.size - 1)){
                if (tree[i] != null){
                    ++curAmount
                    curSum += tree[i]!!
                }
            }
            averOfLevels.add(curSum / curAmount.toDouble())
            curLevelStart = curLevelEnd + 1
            curLevelEnd += offset
            offset *= 2
        }
        return averOfLevels.toDoubleArray()
    }
}

fun main(){
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.left!!.left = TreeNode(15)
    root.left!!.right = TreeNode(7)
    //root.left!!.right!!.right = TreeNode(7)
    //root.left!!.right!!.right!!.right = TreeNode(7)

    //println(Solution().averageOfLevelsTest(listOf(3,9,20,15,7)).joinToString())
    println(Solution().averageOfLevels(root).joinToString())
}
/*
* Нормальное решение:
* class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) {
            return doubleArrayOf()
        }

        val avgs = mutableListOf<Double>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var sum = 0.0

            repeat(levelSize) {
                val node = queue.removeFirst()
                sum += node.`val`
                node?.left?.let {
                    queue.addLast(it)
                }
                node?.right?.let {
                    queue.addLast(it)
                }
            }

            avgs.add(sum/levelSize)
        }

        return avgs.toDoubleArray()
    }
}
* */