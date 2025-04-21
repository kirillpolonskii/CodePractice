package top_interview_150.stack.easy

class Solution {
    fun isValid(s: String): Boolean {
        val openParenth =  mutableListOf<Char>()
        var isValid = true
        for (curCh in s) {
            if (curCh in charArrayOf('(', '[', '{'))
                openParenth.add(curCh)
            else if (curCh in charArrayOf(')', ']', '}')) {
                if (openParenth.isNotEmpty() &&
                    ((curCh == ')' && openParenth.last() == '(') ||
                    (curCh == ']' && openParenth.last() == '[') ||
                    (curCh == '}' && openParenth.last() == '{'))) {
                    openParenth.removeLast()
                }
                else{
                    isValid = false
                    break
                }

            }
        }
        if (openParenth.isNotEmpty())
            isValid = false
        return isValid
    }
}

fun main(){
    println(Solution().isValid("("))
    println(Solution().isValid("(}"))
    println(Solution().isValid("asd(sd)fw(f{fef})"))
    println(Solution().isValid(")"))
}