package top_interview_150.linked_list.meduim

class ListNode86(var `val`: Int) {
         var next: ListNode86? = null
    }

class Solution {
    fun partition(head: ListNode86?, x: Int): ListNode86? {
        val lessDummy = ListNode86(0)
        val greaterDummy = ListNode86(0)
        var less = lessDummy
        var greater = greaterDummy
        var current = head

        while (current != null) {
            if (current.`val` < x) {
                less.next = current
                less = less.next!!
            } else {
                greater.next = current
                greater = greater.next!!
            }
            current = current.next
        }

        greater.next = null
        less.next = greaterDummy.next
        return lessDummy.next
    }
}
