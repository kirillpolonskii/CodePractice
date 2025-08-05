package top_interview_150.graph_general.medium

class Solution200 {
    var totalIslands = 0

    fun numIslands(grid: Array<CharArray>): Int {
        fun eraseNearby(y: Int, x: Int){
            //grid[y][x] = '0'
            if (y - 1 > 0 && grid[y - 1][x] == '1'){
                eraseNearby(y - 1, x)
            }
            if (x + 1 < grid[y].size && grid[y][x + 1] == '1'){
                eraseNearby(y, x + 1)
            }
            if (y + 1 < grid.size && grid[y + 1][x] == '1'){
                eraseNearby(y + 1, x)
            }
            if (x - 1 > 0 && grid[y][x - 1] == '1'){
                eraseNearby(y, x - 1)
            }
            grid[y][x] = '0'
        }

        for (i in grid.indices){
            for (j in grid[i].indices){
                if (grid[i][j] == '1'){
                    ++totalIslands
                    eraseNearby(i, j)
                }
            }
        }
        return totalIslands
    }


}