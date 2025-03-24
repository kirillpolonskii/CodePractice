package top_interview_150.two_pointers.easy

class Solution {
    fun isPalindrome(s: String): Boolean {
        val newS = StringBuilder(s)
            .replace("""[^a-z^A-Z^0-9]""".toRegex(), "").lowercase().toString()
        for (i in 0..<newS.length/2){
            if (newS[i] != newS[newS.length - 1 - i]){
                return false
            }
        }
        return true
    }
}

fun main(){
    Solution().isPalindrome(" ")
}