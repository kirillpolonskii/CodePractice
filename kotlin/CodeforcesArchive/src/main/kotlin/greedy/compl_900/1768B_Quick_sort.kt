package greedy.compl_900

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, k) = readln().split(" ").map { it.toInt() }
        val p = readln().split(" ").map { it.toInt() }
        var numsInRightOrder = 1
        var prevNum = 1
        var prevNumIndex = p.indexOf(1)
        for (i in 0..<n){
            if (p[i] == prevNum + 1){
                if (prevNumIndex < i){
                    ++numsInRightOrder
                    prevNum = p[i]
                    prevNumIndex = i
                }
                else{
                    break
                }
            }
        }
        println(kotlin.math.ceil((n - numsInRightOrder) / k.toDouble()).toInt())
    }
}