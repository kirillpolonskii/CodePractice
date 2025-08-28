package dp.compl_1200

fun main(){
    val T = readln().toInt()
    repeat(T){
        val s = readln()
        var digitsSum = 0
        var amount2 = 0
        var amount3 = 0
        s.forEach { c ->
            digitsSum += c.digitToInt()
            if (c == '2') ++ amount2
            if (c == '3') ++ amount3
        }
        var found = false
        for (i in 0..kotlin.math.min(9, amount2)){
            for (j in 0..kotlin.math.min(9, amount3)){
                if ((digitsSum + i * 2 + j * 6) % 9 == 0){
                    found = true
                    break
                }
            }
            if (found) break
        }
        println(if (found) "YES" else "NO")
    }
}