package top_interview_150.math.easy

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var copyX = x
        var reverseX = 0
        while (copyX > 0){
            reverseX *= 10
            reverseX += copyX % 10
            copyX /= 10
        }
        //println(reverseX)
        return x == reverseX
    }
}

fun main(){
    println(Solution().isPalindrome(-65))
    println(Solution().isPalindrome(0))
    println(Solution().isPalindrome(1))
    println(Solution().isPalindrome(12344321))
    println(Solution().isPalindrome(789))
}