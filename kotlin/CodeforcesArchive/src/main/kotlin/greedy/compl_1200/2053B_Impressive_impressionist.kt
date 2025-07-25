package greedy.compl_1200
// Задачу я решил правильно, но дибильные ограничения не пропускают
fun main(){
    val T = readln().toInt()

    repeat(T){
        val n = readln().toInt()
        val intervals = mutableListOf<Pair<Int, Int>>()
        val unaryIntervals = BooleanArray(2 * n + 1)
        val duplicatedUnaryIntervs = BooleanArray(2 * n + 1)
        for(i in 0..<n){
            val input = readln().split(" ").map{ it.toInt() }
            if (input[0] == input[1]) {
                if (unaryIntervals[input[0]])
                    duplicatedUnaryIntervs[input[0]] = true
                unaryIntervals[input[0]] = true
            }
            intervals.add(Pair(input[0], input[1]))
        }
        val resultArr = BooleanArray(n)
        intervals.forEachIndexed { i, interv ->
            if (interv.first == interv.second){
                if (!duplicatedUnaryIntervs[interv.first]){
                    resultArr[i] = true
                }
            }
            else {
                for (curNum in interv.first..interv.second){
                    if (!unaryIntervals[curNum]){
                        resultArr[i] = true
                        break
                    }
                }
            }

        }
        resultArr.forEach {
            print(if (it) 1 else 0)
        }
        println()

    }
}