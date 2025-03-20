package games.compl_1100

fun main(){
    val T = readln().toInt()
    repeat(T){
        val n = readln().toInt()
        val s = readln()
        val r = readln()
        var winnable = true
        var cur0Amount = s.count { it == '0' }
        var cur1Amount = s.count { it == '1' }
        for (i in 0..n-2){
            if ((cur0Amount <= 0 || cur1Amount <= 0)){
                winnable = false
                break
            }
            when (r[i]){
                '0' -> --cur1Amount
                '1' -> --cur0Amount
            }

        }
        println(if (winnable) "YES" else "NO")
    }
}