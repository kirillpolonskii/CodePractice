package top_interview_150.linked_list.meduim

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode61(var `val`: Int) {
    var next: ListNode61? = null
}
class Solution61 {
    fun rotateRight(head: ListNode61?, k: Int): ListNode61? {
        if (head == null || head.next == null) return head
        val listAsArr = mutableListOf<Int>()
        var curNode = head
        while (curNode != null){
            listAsArr.add(curNode.`val`)
            curNode = curNode.next
        }
        val cutK = k % listAsArr.size
        if (cutK == 0) return head
        var startInd = listAsArr.size - cutK
        var curInd = (listAsArr.size - cutK + 1) % listAsArr.size
        val newHead = ListNode61(listAsArr[startInd])
        var curNewNode = newHead
        while (curInd != startInd){
            curNewNode.next = ListNode61(listAsArr[curInd])
            curNewNode = curNewNode.next!!
            curInd = (curInd + 1) % listAsArr.size
        }
        return newHead
    }
}