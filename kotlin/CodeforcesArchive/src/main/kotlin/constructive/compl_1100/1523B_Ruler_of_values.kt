package constructive.compl_1100

fun main(){
    val T = readln().toInt()

    repeat(T){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }.toMutableList()
        a.add(0, 1)
        println(n / 2 * 6)
        for (i in 1..n/2){
            // oper 1
            println("1 ${i * 2 - 1} ${i * 2}")
            // oper 2
            println("2 ${i * 2 - 1} ${i * 2}")
            // oper 1
            println("1 ${i * 2 - 1} ${i * 2}")
            // oper 2
            println("2 ${i * 2 - 1} ${i * 2}")
            // oper 1
            println("1 ${i * 2 - 1} ${i * 2}")
            // oper 2
            println("2 ${i * 2 - 1} ${i * 2}")
        }
    }
}