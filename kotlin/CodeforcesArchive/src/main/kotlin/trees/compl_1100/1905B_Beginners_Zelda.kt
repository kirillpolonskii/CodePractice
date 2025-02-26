package trees.compl_1100

fun MutableList<MutableList<Int>>.print(add: Int){
    for (v in 0..<this.size){
        print("" + (v+add) + ":")
        for (w in this[v]){
            print(" " + (w+add))
        }
        println()
    }
}

fun BooleanArray.reset(){
    for (i in this.indices){
        this[i] = false
    }
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val frequencies = IntArray(n)
        for (i in 0..<n-1){
            val (v, w) = readln().split(" ").map { it.toInt() - 1 }
            ++frequencies[v]
            ++frequencies[w]
        }
        var leavesAmount = 0
        frequencies.forEach {if (it == 1) ++leavesAmount}
        println((leavesAmount + 1) / 2)
    }
}