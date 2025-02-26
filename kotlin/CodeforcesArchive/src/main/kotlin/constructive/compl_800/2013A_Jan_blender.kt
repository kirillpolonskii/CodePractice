package constructive.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val (x, y) = readln().split(" ").map {it.toInt()}
        println(kotlin.math.ceil(n.toDouble() / kotlin.math.min(x, y)).toInt())
    }
}