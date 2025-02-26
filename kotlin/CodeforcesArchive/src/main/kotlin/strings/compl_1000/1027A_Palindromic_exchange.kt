package strings.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val s = readln()
        var possible = true
        for (i in 0..<n/2) {
            if (s[i] != s[n - 1 - i] && kotlin.math.abs(s[i].code - s[n - 1 - i].code) != 2){
                possible = false
                break
            }
        }
        println(if (possible) "YES" else "NO")
    }
}