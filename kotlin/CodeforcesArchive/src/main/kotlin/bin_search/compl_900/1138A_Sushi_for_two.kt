package bin_search.compl_900

fun main(){
    val n = readln().toInt()
    val sushi = readln().split(" ").map { it.toInt() }
    var curState = if (sushi[0] == 1) 1 else 2
    var last1SeqLength = if (sushi[0] == 1) 1 else 0
    var last2SeqLength = if (sushi[0] == 2) 1 else 0
    var maxNeighborSeqLength = 0
    for (i in 1..<n){
        if (curState == 1){
            if (sushi[i] == 1){
                ++last1SeqLength
            }
            else {
                curState = 2
                maxNeighborSeqLength = kotlin.math.max(maxNeighborSeqLength,
                    2 * kotlin.math.min(last1SeqLength, last2SeqLength))
                last2SeqLength = 1
            }
        }
        else {
            if (sushi[i] == 2){
                ++last2SeqLength
            }
            else {
                curState = 1
                maxNeighborSeqLength = kotlin.math.max(maxNeighborSeqLength,
                    2 * kotlin.math.min(last1SeqLength, last2SeqLength))
                last1SeqLength = 1
            }
        }
    }
    maxNeighborSeqLength = kotlin.math.max(maxNeighborSeqLength,
        2 * kotlin.math.min(last1SeqLength, last2SeqLength))
    println(maxNeighborSeqLength)
}