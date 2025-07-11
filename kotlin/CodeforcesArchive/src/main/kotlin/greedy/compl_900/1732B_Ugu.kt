package greedy.compl_900

fun main(){
    val T = readln().toInt()

    repeat(T){
        val n = readln().toInt()
        val s = readln()
        val split01 = s.split("01")
        val split10 = s.split("10")
        var amount01 = kotlin.math.max(
            0, split01.size - if (split01[0].contains('1')) 1 else 2)
        var amount10 = kotlin.math.max(
            0, split10.size - 1)
        println(amount01 + amount10)
    }
}