package bin_search.compl_1300

fun main(){
    var T = readln().toInt()
    while(T > 0){
        val n = readln().toInt()
        val a = readln().split(" ").map {it.toLong()}.toMutableList()
        if (n == 1){
            println(1)
            --T
            continue
        }
        var maxInterRight = 0
        var maxInterval = Long.MIN_VALUE
        if (n % 2 == 0){
            for (i in 0..<a.size - 1 step 2){
                if (a[i + 1] - a[i] > maxInterval){
                    maxInterval = a[i+1] - a[i]
                }
            }
            if(maxInterval == 1L){
                println(1)
                --T
                continue
            }
            println(maxInterval)
        }
        else {
            for (i in 0..<a.size - 1){
                if (a[i + 1] - a[i] > maxInterval){
                    maxInterval = a[i+1] - a[i]
                }
            }
            if(maxInterval == 1L){
                println(1)
                --T
                continue
            }
            var minK = Long.MAX_VALUE
            for (v in 0..<a.size){
                val aV1 = mutableListOf<Long>()
                aV1.addAll(a)
                val aV2 = mutableListOf<Long>()
                aV2.addAll(a)
                aV1.add(kotlin.math.min(v + 1, a.size - 1), a[v] + 1)
                aV2.add(v, a[v] - 1)
                var maxIntervalV1 = Long.MIN_VALUE
                var maxIntervalV2 = Long.MIN_VALUE
                for (i in 0..<aV1.size - 1 step 2){
                    if (aV1[i + 1] - aV1[i] > maxIntervalV1){
                        maxIntervalV1 = aV1[i+1] - aV1[i]
                    }
                }
                for (i in 0..<aV2.size - 1 step 2){
                    if (aV2[i + 1] - aV2[i] > maxIntervalV2){
                        maxIntervalV2 = aV2[i+1] - aV2[i]
                    }
                }
                minK = kotlin.math.min(kotlin.math.min(maxIntervalV1, minK), maxIntervalV2)
            }
            println(minK)
        }
        --T
    }
}