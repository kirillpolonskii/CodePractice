package top_interview_150.array_string.medium

class Solution151 {
    fun reverseWords(s: String): String {
        val reversedStrBuilder = StringBuilder()
        var curL = s.length - 1
        var curR = s.length - 1
        while(true){
            while(curR > -1 && s[curR] == ' '){
                --curR
            }
            if (curR == -1) break
            curL = curR
            while (curL > -1 && s[curL] != ' '){
                --curL
            }
            reversedStrBuilder.append(s.substring(curL+1..curR)).append(" ")
            curR = curL
            if (curL == -1) break
        }
        reversedStrBuilder.deleteAt(reversedStrBuilder.length - 1)
        return reversedStrBuilder.toString()
    }
}
fun main(){
    print(Solution151().reverseWords("ert       e"))
}