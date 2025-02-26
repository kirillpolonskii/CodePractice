package strings.compl_1000

fun String.longestCommonSubstring(other: String): Pair<Int, Int>{ // (endIndex, length)
    val m = this.length
    val n = other.length
    val lengths = mutableListOf<MutableList<Int>>()
    (0..m).forEach{ i ->
        lengths.add(mutableListOf())
        (0..n).forEach { _ ->
            lengths[i].add(0)
        }
    }
    var maxLength = 0
    var endInd = 0
    (0..m).forEach{ i ->
        (0..n).forEach { j ->
            if (i == 0 || j == 0){
                lengths[i][j] = 0
            }
            else if (this[i - 1] == other[j - 1]){
                lengths[i][j] = lengths[i - 1][j - 1] + 1
                if (lengths[i][j] > maxLength){
                    maxLength = kotlin.math.max(maxLength, lengths[i][j])
                    endInd = i
                }
            }
            else {
                lengths[i][j] = 0
            }
        }
    }

    return Pair(endInd, maxLength)
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        var a = readln()
        var b = readln()
        if (a.length < b.length){
            val temp = a
            a = b
            b = temp
        }
        if (a[0] == b[0]){
            println("YES")
            println(a[0] + "*")
        }
        else if (a[a.length - 1] == b[b.length - 1]){
            println("YES")
            println("*" + a[a.length - 1])
        }
        else if (a.length > 1 && b.length > 1){
            var contains = false
            for (i in 0..b.length-2){
                if (a.contains("${b[i]}${b[i + 1]}")){
                    contains = true
                    println("YES")
                    println("*${b[i]}${b[i + 1]}*")
                    break
                }
            }
            if (!contains) println("NO")
        }
        else {
            println("NO")
        }
    }
}