package dp.compl_1200

fun main(){
    val T = readln().toInt()
    val sums = mutableListOf<Long>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    for (i in 10..200_000) {
        if (i / 100 == 0) {
            sums.add(sums[i - 10] + 1)
        }
        else if (i / 1000 == 0) {
            sums.add(sums[i - 100] + 1)
        }
        else if (i / 10_000 == 0) {
            sums.add(sums[i - 1_000] + 1)
        }
        else if (i / 100_000 == 0) {
            sums.add(sums[i - 10_000] + 1)
        }
        else {
            sums.add(sums[i - 100_000] + 1)
        }
    }
    val sumsOfSums = LongArray(sums.size)
    sumsOfSums[0] = sums[0]
    (1..<sums.size).forEach { index ->
        sumsOfSums[index] = sums[index] + sumsOfSums[index - 1]
    }
    repeat(T){
        val n = readln().toInt()

        println(sumsOfSums[n])
    }
}