package top_interview_150.sliding_window.medium

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        val lettersInWindow = hashSetOf<Char>(s[0])
        var l = 0
        var r = 1
        var maxLength = 1
        while (r < s.length){
            if (lettersInWindow.add(s[r])){
                ++r
                maxLength = kotlin.math.max(maxLength, r - l)
            }
            else {
                maxLength = kotlin.math.max(maxLength, r - l)
                val newL = s.indexOf(s[r], l) + 1
                for (i in l..<newL){
                    lettersInWindow.remove(s[i])
                }
                l = newL
                lettersInWindow.add(s[r])
                ++r
            }
        }
        return maxLength
    }
}

fun main(){
    println(Solution3().lengthOfLongestSubstring("w"))
}