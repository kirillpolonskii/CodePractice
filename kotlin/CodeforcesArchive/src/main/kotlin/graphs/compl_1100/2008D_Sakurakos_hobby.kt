package graphs.compl_1100

fun main(){
    var T = readln().toInt()
    while (T > 0){
        val n = readln().toInt()
        val a = readln().split(" ").map{ it.toInt() }.toMutableList()
        a.add(0, -1)
        val s = readln()
        val connectComponentNum = IntArray(n + 1)
        val connectComponentBlackAmnt = mutableListOf<Int>()
        connectComponentBlackAmnt.add(-1)
        var curConnectComponent = 1
        var curConnectCompBlackAmnt = 0
        for (i in 1..<a.size){
            if (connectComponentNum[i] > 0) continue
            val startElem = i
            var curElem = i
            while (true){
                connectComponentNum[curElem] = curConnectComponent
                if (s[curElem - 1] == '0') ++curConnectCompBlackAmnt
                curElem = a[curElem]
                if(curElem == startElem){
                    connectComponentBlackAmnt.add(curConnectCompBlackAmnt)
                    curConnectCompBlackAmnt = 0
                    ++curConnectComponent
                    break
                }
            }
        }
        for (i in 1..<a.size){
            print("${connectComponentBlackAmnt[connectComponentNum[i]]} ")
        }
        println()

        --T
    }
}