package top_interview_150.hashmap.medium

class Solution49 {
    val freqsArr = IntArray(26)
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val bucketsIndices = mutableMapOf<String, Int>()
        val ans = mutableListOf<MutableList<String>>()
        var curInd = 0
        val sb = StringBuilder()
        for(i in strs.indices) {
            for(j in strs[i].indices) {
                ++freqsArr[strs[i][j].code - 97]
            }
            freqsArr.forEachIndexed { index, f ->
                sb.append((index + 97).toChar()).append(f)
            }
            val curHash = sb.toString()
            println(curHash)
            if (!bucketsIndices.containsKey(curHash)){
                bucketsIndices.put(curHash, curInd)
                ans.add(mutableListOf(strs[i]))
                ++curInd
            }
            else {
                ans[bucketsIndices.get(curHash)!!].add(strs[i])
            }
            (0..25).forEach { i -> freqsArr[i] = 0 }
            sb.clear()
        }

        return ans
    }


}
fun main(){
    println(Solution49().groupAnagrams(arrayOf("bdddddddddd","bbbbbbbbbbc")))
}