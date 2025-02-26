package two_pointers.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        var s = readln()
        s = s + ","
        val workingKeys = BooleanArray(26)
        var curOccurAmount = 1
        (1..<s.length).forEach {
            if (s[it] == s[it - 1]){
                ++curOccurAmount
            }
            else {
                if (curOccurAmount % 2 == 1){
                    workingKeys[s[it - 1].code - 97] = true
                }
                curOccurAmount = 1
            }
        }
        workingKeys.forEachIndexed { index, el ->
            if (el){
                print((index + 97).toChar())
            }
        }
        println()
    }
}