package flows.compl_1300

fun main(){
    val (n, h) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toLong() }
    var sortedSliceA: List<Long>
    var remainingSpace: Long
    var remainingHeight: Long
    var k = 1
    var allSpaceTaken = false
    while (k < n){
        sortedSliceA = a.slice(0..<k).sortedDescending()
        remainingSpace = 2 * h
        remainingHeight = h
        var curInd = 0
        while (remainingSpace - sortedSliceA[curInd] >= 0){
            remainingSpace -= sortedSliceA[curInd]
            if (curInd % 2 == 0) remainingHeight -= sortedSliceA[curInd]
            if (remainingHeight < 0){
                allSpaceTaken = true
                --k
                break
            }
            if (curInd == sortedSliceA.size - 1){
                if (remainingSpace > 0){
                    ++k
                }
                else {
                    allSpaceTaken = true
                }
                break
            }
            else{
                ++curInd
            }
        }
        if (allSpaceTaken) break
    }
    println(k)

}