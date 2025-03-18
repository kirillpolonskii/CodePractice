package matching.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val b = readln().split(" ").map { it.toInt() }
        var exist = true
        for (i in 1..n-4)  {
            if (b[i] == 0 && b[i - 1] == 1 && b[i + 1] == 1){
                exist = false
                break
            }
        }
        println(if (exist) "YES" else "NO")
    }
}