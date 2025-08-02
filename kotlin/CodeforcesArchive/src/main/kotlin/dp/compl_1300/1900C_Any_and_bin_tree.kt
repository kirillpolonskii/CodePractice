package dp.compl_1300

fun main(){
    val T = readln().toInt()

    repeat(T){
        var n = readln().toInt()
        val letters = "X" + readln()
        val tree = mutableListOf<Pair<Int, Int>>()
        tree.add(Pair(-1, -1))
        val parentOf = IntArray(n + 1)
        parentOf[1] = -1
        // при DFS из листьев в этом массиве будет содержаться минимальное кол-во
        // исправлений, необходимое для достижения ближайшего листа.
        // Таким образом, его 1-й элемент (корневое значение) будет ответом
        val minPathsFromLeafs = IntArray(n + 1)
        val leafs = mutableListOf<Int>()
        val visited = BooleanArray(n + 1)
        for (i in 1..n){
            val (l, r) = readln().split(" ").map { it.toInt() }
            tree.add(Pair(l, r))
            parentOf[l] = i
            parentOf[r] = i
            if (l == 0 && r == 0) leafs.add(i)
        }
        for (i in 0..<leafs.size){
            var curNode = leafs[i]
            var parent = parentOf[curNode]
            while (true){ // пока не в корне
                //println("visited=${visited.joinToString()}")
                parent = parentOf[curNode]
                //println("curNode=$curNode, parent=$parent")
                val isLeftChild = tree[parent].first == curNode
                if (isLeftChild){
                    if (letters[parent] != 'L'){
                        if (minPathsFromLeafs[parent] <= minPathsFromLeafs[curNode] + 1 &&
                            visited[parent])
                            break
                        else {
                            minPathsFromLeafs[parent] = minPathsFromLeafs[curNode] + 1
                            visited[curNode] = true
                            visited[parent] = true
                        }
                    }
                }
                else {
                    if (letters[parent] != 'R'){
                        if (minPathsFromLeafs[parent] <= minPathsFromLeafs[curNode] + 1 &&
                            visited[parent])
                            break
                        else {
                            minPathsFromLeafs[parent] = minPathsFromLeafs[curNode] + 1
                            visited[curNode] = true
                            visited[parent] = true
                        }
                    }
                }
                visited[curNode] = true
                visited[parent] = true
                curNode = parent
                if (curNode == 1) break
            }
        }
        println(minPathsFromLeafs[1])
    }
}