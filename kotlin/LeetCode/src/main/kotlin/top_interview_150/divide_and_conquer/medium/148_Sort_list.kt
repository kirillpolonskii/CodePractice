package top_interview_150.divide_and_conquer.medium

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head == null) return null
        var minEl = Int.MAX_VALUE
        var maxEl = Int.MIN_VALUE
        var curEl = head
        while (curEl != null){
            if(curEl.`val` < minEl) minEl = curEl.`val`
            if(curEl.`val` > maxEl) maxEl = curEl.`val`
            curEl = curEl.next
        }
        var offsetToZero = if(minEl < 0) -minEl else 0
        val freqsArr = IntArray(maxEl + offsetToZero + 1)
        curEl = head
        while (curEl != null){
            ++freqsArr[curEl.`val` + offsetToZero]
            curEl = curEl.next
        }
        var sortedHead = ListNode(0)
        curEl = sortedHead
        freqsArr.forEachIndexed { index, el ->
            if (el > 0){
                (1..el).forEach {
                    curEl?.`val` = index - offsetToZero
                    if (it != el || index != maxEl + offsetToZero) {
                        curEl?.next = ListNode(0)
                        curEl = curEl?.next
                    }
                }
            }
        }
        return sortedHead
    }
}