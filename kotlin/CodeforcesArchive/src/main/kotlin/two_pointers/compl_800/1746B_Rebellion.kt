package two_pointers.compl_800

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var leftest1 = 0
        var rightest0 = a.size - 1
        while (leftest1 < a.size && a[leftest1] == 0){
            ++leftest1
        }
        while (rightest0 > -1 && a[rightest0] == 1){
            --rightest0
        }
        var moves = 0
        if (rightest0 != -1 && leftest1 != a.size){
            while (rightest0 != -1 && leftest1 != a.size && rightest0 > leftest1){
                ++leftest1
                --rightest0
                ++moves
                while (leftest1 < a.size && a[leftest1] == 0){
                    ++leftest1
                }
                while (rightest0 > -1 && a[rightest0] == 1){
                    --rightest0
                }
            }
        }
        println(moves)
    }
}