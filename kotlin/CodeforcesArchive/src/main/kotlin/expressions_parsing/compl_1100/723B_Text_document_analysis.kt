package expressions_parsing.compl_1100

fun main(){
    val n = readln().toInt()
    var s = readln()
    val s1 = StringBuilder(s)
    s = s1
        .append("_")
        .replace("_{2,}".toRegex(), "_")
        .replace("""_+\(""".toRegex(), "(")
        .replace("""\(_+""".toRegex(), "(")
        .replace("""_+\)""".toRegex(), ")")
        .replace("""\)_+""".toRegex(), ")")

    //println(s)
    var curWordOutsideSize = 0
    var curWordsInsideAmount = 0
    var isCountingOutside = true
    var curStr = ""
    s.forEachIndexed { ind, ch ->
        when (ch) {
            '_' -> {
                if (isCountingOutside){
                    curWordOutsideSize = kotlin.math.max(curWordOutsideSize, curStr.length)
                    curStr = ""
                }
                else {
                    ++curWordsInsideAmount
                }

            }
            '(' -> {
                isCountingOutside = false
                curWordOutsideSize = kotlin.math.max(curWordOutsideSize, curStr.length)
                curStr = ""
            }
            ')' -> {
                isCountingOutside = true
                curStr = ""
                if (s[ind - 1] != '(') ++curWordsInsideAmount
            }
            else -> {
                curStr += ch
                //println(curStr)
            }

        }
    }
    println("$curWordOutsideSize $curWordsInsideAmount")
}