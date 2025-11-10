package top_interview_150.linked_list.meduim

class ListNode92(var `val`: Int) {
    var next: ListNode92? = null
    }

class Solution92 {
    fun reverseBetween(head: ListNode92?, left: Int, right: Int): ListNode92? {
        if (right == left) return head
        val oddityOffset = if ((right - left + 1) % 2 == 0) 0 else 1
        val firstHalfOfList = mutableListOf<ListNode92>()
        var curInd = 1
        val middleInd = (right + left) / 2
            var curNode = head
        while (curInd < left){
            curNode = curNode!!.next
            ++curInd
        }
        while (curInd <= middleInd){
            firstHalfOfList.add(curNode!!)
            ++curInd
            curNode = curNode.next
        }
        var temp = 0
        var curBackOffset = 0
        while (curInd <= right){
            temp = curNode!!.`val`
            curNode.`val` = firstHalfOfList[firstHalfOfList.size - 1 - oddityOffset - curBackOffset].`val`
            firstHalfOfList[firstHalfOfList.size - 1 - oddityOffset - curBackOffset].`val` = temp
            ++curInd
            curNode = curNode.next
            ++curBackOffset
        }
        return head
    }
}