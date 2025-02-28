package flows.compl_1100

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val a = readln()
            .split(" ")
            .map { it.toLong() }
            .sorted()
            .toMutableList()
        //a.forEach { print(it.toString() + " ") }
        //println()
        val possible = BooleanArray(n + 1)
        possible[0] = true
        //possible.forEach { print(it.toString() + " ") }
        //println()
        for (i in n-1 downTo 0){
            while (a[i] > 0){
                if (a[i] <= n){
                    if (possible[(a[i]).toInt()]){
                        a[i] /= 2L
                    }
                    else {
                        possible[(a[i]).toInt()] = true
                        break
                    }
                }
                else {
                    a[i] /= 2L
                }
            }
            //possible.forEach { print(it.toString() + " ") }
            //println()
        }

        println(if (possible.contains(false)) "NO" else "YES")

    }


}