package matrices.compl_1300

fun main(){
    val T = readln().toInt()

    repeat(T){
        var (n, m) = readln().split(" ").map{ it.toInt() }
        val carpet = mutableListOf<String>()
        repeat(n){
            carpet.add(readln())
        }
        val layersAmount = kotlin.math.min(n, m) / 2
        var entriesAmount = 0
        val curLayer = CharArray(4005)
        for (layerNum in 0..<layersAmount){
            var layerPos = 0
            for (j in layerNum..<m - layerNum){
                curLayer[layerPos++] = carpet[layerNum][j]
            }
            for (j in layerNum+1..<n - layerNum - 1){
                curLayer[layerPos++] = carpet[j][m - layerNum - 1]
            }
            for (j in m - layerNum - 1 downTo layerNum){
                curLayer[layerPos++] = carpet[n - layerNum - 1][j]
            }
            for (j in n - layerNum - 2 downTo layerNum + 1){
                curLayer[layerPos++] = carpet[j][layerNum]
            }

            for (j in 0..<layerPos){
                if (curLayer[j] == '1' && curLayer[(j + 1) % layerPos] == '5' &&
                    curLayer[(j + 2) % layerPos] == '4' && curLayer[(j + 3) % layerPos] == '3')
                    ++entriesAmount
            }

        }
        println(entriesAmount)
    }
}