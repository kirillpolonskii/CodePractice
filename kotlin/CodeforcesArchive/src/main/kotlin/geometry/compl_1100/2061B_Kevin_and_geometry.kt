package geometry.compl_1100

fun main(){
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }.sorted().toMutableList()
        val equalSticksInd = mutableListOf<Int>()
        var curInd = 0
        while (curInd < n-1) {
            if (a[curInd] == a[curInd + 1]){
                equalSticksInd.add(curInd)
                ++curInd
            }
            ++curInd
        }
        if (equalSticksInd.isEmpty()){
            print(-1)
        }
        else if (equalSticksInd.size >= 2){
            print("" + a[equalSticksInd[0]] + " " +
                    a[equalSticksInd[0] + 1] + " " +
                    a[equalSticksInd[1]] + " " +
                    a[equalSticksInd[1] + 1])
        }
        else {
            val side = a[equalSticksInd[0]]
            a.removeAt(equalSticksInd[0] + 1)
            a.removeAt(equalSticksInd[0])
            var found = false
            for (i in 0..n-4){
                if (a[i + 1] - a[i] < 2 * side){
                    found = true
                    print("" + side + " " +
                            side + " " +
                            a[i] + " " +
                            a[i + 1])
                    break
                }
            }
            if (!found) print(-1)
        }

        println()
    }
}