package greedy.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (a, b) = readln().split(" ").map{it.toInt()}
        if (a == 0){
            println(1)
        }
        else {
            println(a + 2 * b + 1)
        }
    }
}