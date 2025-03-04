package dp.compl_1100

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val a = readln().split(" ")
            .map { it.toLong() }
            .mapIndexed{ind, el -> el to ind + 1}
            .toMutableList()
        a.add(0, 0L to 0)
        a.sortWith { pair1, pair2 ->
            if (pair1.first > pair2.first){
                1
            }
            else if (pair1.first < pair2.first){
                -1
            }
            else {
                if (pair1.second > pair2.second){
                    1
                }
                else if (pair1.second < pair2.second){
                    -1
                }
                else {
                    0
                }
            }
        }
        //println(a)
        val next = IntArray(n + 1)
        val prefSum = LongArray(n + 1)
        val ans = IntArray(n + 1)
        for (i in 1..n){
            if (next[i - 1] >= i){
                next[i] = next[i - 1]
                prefSum[i] = prefSum[i - 1]
            }
            else {
                prefSum[i] = prefSum[i - 1] + a[i].first
                next[i] = i
                while (next[i] + 1 <= n && prefSum[i] >= a[next[i] + 1].first){
                    ++next[i]
                    prefSum[i] += a[next[i]].first
                }
            }
            ans[a[i].second] = next[i]
        }
        for (i in 1..n){
            print((ans[i] - 1).toString() + " ")
        }
        println()
    }
}