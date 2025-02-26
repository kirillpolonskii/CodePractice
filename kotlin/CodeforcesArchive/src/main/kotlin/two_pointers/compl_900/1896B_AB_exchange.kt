package two_pointers.compl_900

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        var s = readln()
        s += "C"
        var leftestAInd = 0
        var rightestBInd = 0
        var operationsAmount = 0
        while (s[leftestAInd] == 'B'){
            ++leftestAInd
            ++rightestBInd
        }
        while (leftestAInd < n){
            var amountA = 0
            var amountB = 0
            while (s[rightestBInd] == 'A'){
                ++rightestBInd
                ++amountA
            }
            while (s[rightestBInd] == 'B'){
                ++rightestBInd
                ++amountB
            }
            if (s[rightestBInd - 1] == 'B'){
                operationsAmount += rightestBInd - leftestAInd - 1
            }
            if (amountB > 0){
                leftestAInd = rightestBInd - 1
            }
            else {
                break
            }
        }
        println(operationsAmount)
    }
}