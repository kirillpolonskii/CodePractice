package top_interview_150.linked_list.meduim

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var curL1 = l1
        var curL2 = l2
        var nextAddition = 0
        var curDigit = curL1!!.`val` + curL2!!.`val` + nextAddition
        println(curDigit)
        val head = ListNode(if (curDigit > 9) curDigit - 10 else curDigit)
        var curSumL = head
        nextAddition = if (curDigit > 9) 1 else 0
        while (curL1?.next != null || curL2?.next != null){
            curDigit = nextAddition +
                    (if (curL1?.next != null) curL1.next!!.`val` else 0) +
                    (if (curL2?.next != null) curL2.next!!.`val` else 0)
            println(curDigit)
            nextAddition = if (curDigit > 9) 1 else 0
            curSumL.next = ListNode(if (curDigit > 9) curDigit - 10 else curDigit)
            curSumL = curSumL.next!!
            curL1 = curL1?.next
            curL2 = curL2?.next
        }
        if (nextAddition == 1) {
            curSumL.next = ListNode(1)
        }
        return head
    }
}

fun main(){
    val head1 = ListNode(2)
    head1.next = ListNode(4)
    head1.next!!.next = ListNode(3)
    val head2 = ListNode(5)
    head2.next = ListNode(6)
    head2.next!!.next = ListNode(4)
    println(Solution().addTwoNumbers(head1, head2)?.`val`)
}