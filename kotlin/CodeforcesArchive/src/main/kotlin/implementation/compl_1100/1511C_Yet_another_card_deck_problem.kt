package implementation.compl_1100

fun main(){
    val (n, q) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }.reversed().toMutableList()
    val t = readln().split(" ").map { it.toInt() }
    t.forEach { curT ->
        val curInd = a.indexOfLast { it == curT }
        val curCard = a[curInd]
        a.removeAt(curInd)
        a.add(curCard)
        print("${n - curInd} ")
    }
}