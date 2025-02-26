package matrices.compl_900

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, m) = readln().split(" ").map { it.toInt() }
        for (i in 1..n){
            for (j in 1..m){
                print(if ((i % 4 <= 1) != (j % 4 <= 1)) 0 else 1)
                print(if (j != m) " " else "\n")
            }
        }
    }
}