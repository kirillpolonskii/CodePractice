package ternary_search.compl_1300

fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toLong() }.sorted()
    val sumA = a.sum()
    val m = readln().toInt()
    repeat(m){
        val (arm, att) = readln().split(" ").map { it.toLong() }
        val potentHeroInd = a.binarySearch(arm)
        var coinToDefend = 0L
        var coinToAttack = 0L
        if (potentHeroInd >= 0){ // send this hero to beat the shit out of the lizard
            val sumWithoutHero = sumA - a[potentHeroInd]
            coinToDefend = kotlin.math.max(0L, att - sumWithoutHero)
        }
        else { // 3 possible outcomes
            if (potentHeroInd == -1){ // arm of lizard is too small
                val sumWithoutHero = sumA - a[0]
                coinToDefend = kotlin.math.max(0L, att - sumWithoutHero)
            }
            else if (potentHeroInd == -a.size - 1){ // arm of lizard is too big
                coinToAttack = arm - a.last()
                val sumWithoutHero = sumA - a.last()
                coinToDefend = kotlin.math.max(0L, att - sumWithoutHero)
            }
            else {
                val hero1 = a[-potentHeroInd - 1 - 1] // hero with power < arm
                val hero2 = a[-potentHeroInd - 1] // hero with power > arm
                if (arm - hero1 + kotlin.math.max(0L, att - (sumA - hero1)) <
                    kotlin.math.max(0L, att - (sumA - hero2))){ // choose which is cheaper: a) send hero1; b) send hero2
                    coinToAttack = arm - hero1
                    val sumWithoutHero = sumA - hero1
                    coinToDefend = kotlin.math.max(0L, att - sumWithoutHero)
                }
                else {
                    coinToAttack = 0L
                    coinToDefend = kotlin.math.max(0L, att - (sumA - hero2))
                }
            }
        }
        println(coinToAttack + coinToDefend)
    }
}