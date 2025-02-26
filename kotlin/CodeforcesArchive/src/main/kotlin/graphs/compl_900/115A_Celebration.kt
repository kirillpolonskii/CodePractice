package graphs.compl_900

import kotlin.math.min

val tree = mutableListOf<MutableList<Int>>()
val visited = mutableListOf<Boolean>()

fun countMaxDepth(root: Int, curDepth: Int): Int {
    if (tree.get(root).isEmpty()){
        return curDepth
    }
    else {
        var childrenMaxDepth = 0
        tree.get(root).forEach {
            childrenMaxDepth = kotlin.math.max(childrenMaxDepth, countMaxDepth(it, curDepth + 1))
        }
        return childrenMaxDepth
    }
}

fun main(){
    val n = readln().toInt()

    val roots = mutableListOf<Int>()
    for (i in 0..<n){
        tree.add(mutableListOf())
        visited.add(false)
    }
    for (i in 0..<n){
        var boss = readln().toInt()
        --boss
        if (boss == -2){
            roots.add(i)
        }
        else {
            tree[boss].add(i)
        }
    }
    var minGroupAmount = 0
    roots.forEach {
        minGroupAmount = kotlin.math.max(minGroupAmount, countMaxDepth(it, 1))
    }
    println(minGroupAmount)
    /*roots.forEach{ print(" " + it) }
    println()
    tree.forEachIndexed { ind, list ->
        print(""+ind + ":")
        list.forEach { print(" " + it) }
        println()
    }*/
}