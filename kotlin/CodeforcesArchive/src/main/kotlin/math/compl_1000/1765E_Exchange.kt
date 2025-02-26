package math.compl_1000

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, a, b) = readln().split(" ").map { it.toInt() }
        if (a <= b){
            println(kotlin.math.ceil(n.toDouble() / a).toInt())
        }
        else {
            println(1)
        }
    }
}