package top_interview_150.backtracking.medium

class Solution {
    val combsList = mutableListOf<String>()
    val map = mapOf<Char, String>(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        recursiveBuilder(digits, 0, "")
        return combsList
    }

    fun recursiveBuilder(digits: String, curInd: Int, curString: String){
        map[digits[curInd]]?.let {
            for (curSymb in it){
                val newString = curString + curSymb
                if (curInd == digits.length - 1) {
                    combsList.add(newString)
                }
                else {
                    recursiveBuilder(digits, curInd + 1, newString)
                }
            }
        }
    }
}