package sorting_algos.compl_1000

fun main(){
    val n = readln().toInt()
    val widths = mutableListOf<Long>()
    val heights = mutableListOf<Long>()
    repeat(n){
        val (w, h) = readln().split(" ").map{ it.toLong() }
        widths.add(w)
        heights.add(h)
    }
    var prevMax = 1_000_000_001L
    var possible = true
    for (i in 0..<n) {
        if (widths[i] < heights[i]) widths[i] = heights[i].also { heights[i] = widths[i] }
        if (widths[i] <= prevMax){
            prevMax = widths[i]
        }
        else {
            if (heights[i] <= prevMax){
                prevMax = heights[i]
            }
            else{
                possible = false
                break
            }
        }
    }
    println(if (possible) "YES" else "NO")
}