package geometry.compl_900

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, point) = readln().split(" ").map { it.toInt() }
        val intervals = mutableListOf<Pair<Int, Int>>()
        repeat(n){
            val (l, r) = readln().split(" ").map { it.toInt() }
            intervals.add(Pair(l, r))
        }
        intervals.removeIf{it.first > point || it.second < point}
        if(intervals.isEmpty()){
            println("NO")
        }
        else {
            val intersectionLeft = intervals.map { it.first }
                //.onEach {print(" " + it)}
                .max()
            val intersectionRight = intervals.map { it.second }
                //.onEach {print(" " + it)}
                .min()
            if (intersectionLeft == intersectionRight){
                println("YES")
            }
            else {
                println("NO")
            }
        }
    }
}