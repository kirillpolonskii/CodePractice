package top_interview_150.linked_list.meduim

class ListNode2(var `val`: Int) {
    var next: ListNode2? = null
}

class Solution2 {
    fun addTwoNumbers(l1: ListNode2?, l2: ListNode2?): ListNode2? {
        var curL1 = l1
        var curL2 = l2
        var nextAddition = 0
        var curDigit = curL1!!.`val` + curL2!!.`val` + nextAddition
        println(curDigit)
        val head = ListNode2(if (curDigit > 9) curDigit - 10 else curDigit)
        var curSumL = head
        nextAddition = if (curDigit > 9) 1 else 0
        while (curL1?.next != null || curL2?.next != null){
            curDigit = nextAddition +
                    (if (curL1?.next != null) curL1.next!!.`val` else 0) +
                    (if (curL2?.next != null) curL2.next!!.`val` else 0)
            println(curDigit)
            nextAddition = if (curDigit > 9) 1 else 0
            curSumL.next = ListNode2(if (curDigit > 9) curDigit - 10 else curDigit)
            curSumL = curSumL.next!!
            curL1 = curL1?.next
            curL2 = curL2?.next
        }
        if (nextAddition == 1) {
            curSumL.next = ListNode2(1)
        }
        return head
    }
}

fun main(){
    val head1 = ListNode2(2)
    head1.next = ListNode2(4)
    head1.next!!.next = ListNode2(3)
    val head2 = ListNode2(5)
    head2.next = ListNode2(6)
    head2.next!!.next = ListNode2(4)
    println(Solution2().addTwoNumbers(head1, head2)?.`val`)
}