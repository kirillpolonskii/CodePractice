package strings.compl_1200

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val n = readln().toInt()
        val s = readln()
        var freqs = mutableListOf<Pair<Char, Int>>()
        for (i in 0..25){
            freqs.add(Pair(('a'.code + i).toChar(), 0))
        }
        s.forEach { ch ->
            freqs[ch.code - 'a'.code] = freqs[ch.code - 'a'.code].copy(second = freqs[ch.code - 'a'.code].second + 1)
        }
        freqs = freqs.sortedWith { o1, o2 ->
            o2.second - o1.second
        }.toMutableList()
        val printQueue = ArrayDeque<Pair<Char, Int>>()
        while (freqs[0].second > freqs[1].second){
            print(freqs[0].first)
            freqs[0] = freqs[0].copy(second = freqs[0].second - 1)
        }
        for(i in 0..25){
            printQueue.add(freqs[i])
        }
        while (printQueue.isNotEmpty()){
            val curPair = printQueue.first()
            printQueue.removeFirst()
            if (curPair.second == 0){
                continue
            }
            print(curPair.first)
            printQueue.add(curPair.copy(second = curPair.second - 1))
        }
        println()

        --T
    }
}