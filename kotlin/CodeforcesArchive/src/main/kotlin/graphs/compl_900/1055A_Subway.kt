package graphs.compl_900

fun main(){
    val input = readln().split(" ").map { it.toInt() }
    var (n, s) = input
    --n
    --s
    val a  = readln().split(" ").map { it.toInt() }
    val b  = readln().split(" ").map { it.toInt() }
    if (a[0] == 0){
        println("NO")
    } else{
        val c: MutableList<Int> = mutableListOf()
        a.forEachIndexed { index, value -> c.add(value + b[index]) }
        var containsReachableTrans = a[s] == 1
        for (i in s..n){
            if (c[i] == 2) {
                containsReachableTrans = true
            }
        }
        if (c[s] > 0 && containsReachableTrans) {
            println("YES")
        }
        else {
            println("NO")
        }
    }
}