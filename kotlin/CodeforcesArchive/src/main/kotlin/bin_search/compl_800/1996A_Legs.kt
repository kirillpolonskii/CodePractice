package bin_search.compl_800

fun main(){
    val t: Int = readln().toInt()
    repeat(t){
        val n: Int = readln().toInt()
        println(n / 4 + (n % 4) / 2)
    }

}