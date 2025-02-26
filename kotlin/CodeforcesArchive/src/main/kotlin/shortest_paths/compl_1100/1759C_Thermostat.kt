package shortest_paths.compl_1100

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (l, r, x) = readln().split(" ").map { it.toInt() }
        var (a, b) = readln().split(" ").map { it.toInt() }
        if (a > b) a = b.also { b = a }
        if (a == b){
            println(0)
        }
        else if (b - a >= x){
            println(1)
        }
        else if ((a - l >= x && b - l >= x) ||
            (r - a >= x && r - b >= x)){
            println(2)
        }
        else if ((a - l >= x && r - l >= x && r - b >= x) ||
            (r - a >= x && r - l >= x && b - l >= x)){
            println(3)
        }
        else {
            println(-1)
        }
    }
}