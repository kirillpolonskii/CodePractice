package graphs.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val input = readln().split(" ").map { it.toInt() }
        val n = input[0]; val k = input[1]
        println(if (k < n - 1) n else 1)
    }
}