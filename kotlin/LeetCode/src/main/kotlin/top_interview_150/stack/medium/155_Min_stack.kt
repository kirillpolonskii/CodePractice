package top_interview_150.stack.medium

import kotlin.math.min

class MinStack() {
    var top: Node? = null

    fun push(`val`: Int) {
        val min: Int = top?.min?.let { if (`val` < it) `val` else it } ?: `val`
        val node = Node(`val`, min)
        node.next = top
        top = node
    }

    fun pop() {
        top = top?.next
    }

    fun top(): Int {
        return top!!.value
    }

    fun getMin(): Int {
        return top!!.min
    }

    data class Node(
        val value: Int,
        val min: Int,
        var next: Node? = null
    )

}