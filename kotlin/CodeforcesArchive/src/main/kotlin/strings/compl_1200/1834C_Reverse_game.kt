package strings.compl_1200

fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val s = readln()
        val t = readln()
        val revT = t.reversed()
        var diffSymbST = 0
        var diffSymbSRevT = 0
        (0..<n).forEach {
            if (s[it] != t[it]) ++diffSymbST
            if (s[it] != revT[it]) ++diffSymbSRevT
        }
        var ans = 0
        if (diffSymbSRevT == 0) {
            if (s == t) ans = 0
            else ans = 2
        }
        else ans = kotlin.math.min(
            2 * diffSymbST - (diffSymbST % 2),
            2 * diffSymbSRevT - (1 - diffSymbSRevT % 2)
        )
        println(ans)
    }
}