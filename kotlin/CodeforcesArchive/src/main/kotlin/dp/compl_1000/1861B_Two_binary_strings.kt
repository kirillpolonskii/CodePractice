package dp.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        val a = readln()
        val b = readln()
        var possible = false
        for (i in 0..<a.length) {
            if (a[i] == '0' && b[i] == '0' && a[i+1] == '1' && b[i+1] == '1'){
                possible = true
                break
            }
        }
        println(if (possible) "YES" else "NO")
    }
}