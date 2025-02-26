package combinatorics.compl_800

fun printAnswer(foundPoint: Boolean, neg1: Int, pos1: Int){
    if (foundPoint){
        println("YES")
        (1..neg1).forEach{
            print("" + -1 + " ")
        }
        (1..pos1).forEach{
            print("" + 1 + " ")
        }
    }
    else {
        print("NO")
    }

    println()
}

fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n, k) = readln().split(" ").map { it.toInt() }
        var neg1Amount = 0
        var pos1Amount = 0
        var foundPoint = false
        while (neg1Amount < 101){
            pos1Amount = 0
            while (pos1Amount < 101){
                if (neg1Amount * neg1Amount + pos1Amount * pos1Amount == n + 2 * k &&
                    neg1Amount + pos1Amount == n){
                    foundPoint = true
                    break
                }
                ++pos1Amount
            }
            if (foundPoint) break
            ++neg1Amount

        }
        printAnswer(foundPoint, neg1Amount, pos1Amount)
    }
}