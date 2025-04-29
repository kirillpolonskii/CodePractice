package top_interview_150.hashmap.easy

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineFreqs = IntArray(28)
        magazine.forEach {
            ++magazineFreqs[it.code - 97]
        }
        var ans = true
        for (letter in ransomNote){
            if (magazineFreqs[letter.code - 97] == 0){
                ans = false
                break
            }
            else {
                --magazineFreqs[letter.code - 97]
            }
        }
        return ans
    }
}