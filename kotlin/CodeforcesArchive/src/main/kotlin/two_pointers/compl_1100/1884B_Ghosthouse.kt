package two_pointers.compl_1100

fun main(){
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val s = readln()
        val zerosAmount = s.count { it == '0' }
        val moves = LongArray(n + 1) { _ -> -1L}
        moves[0] = 0
        var curInd = s.length - 1 // pointer to bit that determines divisibility by 2^(s.length - curInd)
        var prevClosestZero = s.length - 1
        var curClosestZero = s.length - 1
        while (prevClosestZero > -1 && s.length - curInd <= zerosAmount){
            //println(moves.joinToString())
            while (s[curClosestZero] == '1'){
                --curClosestZero
            }
            moves[s.length - curInd] = moves[s.length - curInd - 1] +
                    (prevClosestZero - curClosestZero) +
                    (curInd - prevClosestZero)
            prevClosestZero = curClosestZero
            curClosestZero -= 1
            --curInd

        }

        (1..n).forEach {
            print("${moves[it]} ")
        }
        println()
    }
}