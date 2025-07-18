package top_interview_150.stack.medium

class Solution {
    fun simplifyPath(path: String): String {
        val dividedPath = path
            .replace("""//""".toRegex(), "/")
            //.also {println(it)}
            .split("/")
            .toMutableList()
        dividedPath.removeIf { s -> s.isEmpty() || s == "." }
        //println(dividedPath.joinToString())
        val canonPath = mutableListOf<String>()
        for (i in dividedPath.indices) {
            if (dividedPath[i] == ".." && canonPath.isNotEmpty()){
                canonPath.removeLast()
            }
            else {
                if (dividedPath[i] != "..")
                    canonPath.add(dividedPath[i])
            }
        }
        return "/" + canonPath.joinToString("/")
    }
}

fun main(){
    println(Solution().simplifyPath("/.../a/../b////c/../d/./"))
}