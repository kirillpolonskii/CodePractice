package math.compl_900

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (a, b, m) = readln().split(" ").map { it.toULong() }
        println(m / a + m / b + 2UL)
    }
}