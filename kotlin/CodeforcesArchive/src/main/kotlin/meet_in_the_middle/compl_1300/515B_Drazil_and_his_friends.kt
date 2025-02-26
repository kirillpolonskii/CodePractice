package meet_in_the_middle.compl_1300

fun findGCD(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        findGCD(b, a % b)
    }
}

fun main(){
    val (n, m) = readln().split(" ").map{it.toInt()}
    val inputBoys = readln().split(" ").map{it.toInt()}
    val inputGirls = readln().split(" ").map{it.toInt()}
    val happyBoys = BooleanArray(n)
    val happyGirls = BooleanArray(m)
    if (inputBoys[0] != 0){
        (1..inputBoys[0]).forEach {
            happyBoys[inputBoys[it]] = true
        }
    }
    if (inputGirls[0] != 0){
        (1..inputGirls[0]).forEach {
            happyGirls[inputGirls[it]] = true
        }
    }
    var possible = true
    val gcd = findGCD(n, m)
    for (i in 0..<gcd){
        if (happyBoys.filterIndexed { ind, el -> el && (ind % gcd == i) }.isEmpty() &&
            happyGirls.filterIndexed { ind, el -> el && (ind % gcd == i) }.isEmpty()) {
            possible = false
            break
        }
    }
    println(if (possible) "Yes" else "No")
}