package questions.leetcode.editor.en;

//You are given an m x n grid where each cell can have one of three values: 
//
// 
// 0 representing an empty cell, 
// 1 representing a fresh orange, or 
// 2 representing a rotten orange. 
// 
//
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten 
//orange becomes rotten. 
//
// Return the minimum number of minutes that must elapse until no cell has a 
//fresh orange. If this is impossible, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never 
//rotten, because rotting only happens 4-directionally.
// 
//
// Example 3: 
//
// 
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer 
//is just 0.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] is 0, 1, or 2. 
// 
//
// Related Topics Array Breadth-First Search Matrix 👍 9639 👎 331


//You are given an m x n grid where each cell can have one of three values: 
//
// 
// 0 representing an empty cell, 
// 1 representing a fresh orange, or 
// 2 representing a rotten orange. 
// 
//
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten 
//orange becomes rotten. 
//
// Return the minimum number of minutes that must elapse until no cell has a 
//fresh orange. If this is impossible, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never 
//rotten, because rotting only happens 4-directionally.
// 
//
// Example 3: 
//
// 
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer 
//is just 0.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] is 0, 1, or 2. 
// 
//
// Related Topics Array Breadth-First Search Matrix 👍 9639 👎 331


import java.util.ArrayDeque;
import java.util.Deque;

public class Q994RottingOranges {
    public static void main(String[] args) {
        Solution solution = new Q994RottingOranges().new Solution();
        solution.orangesRotting(new int[][]{
//                new int[]{0, 1, 1, 2},
//                new int[]{0, 1, 1, 0},
//                new int[]{1, 1, 2, 0},
                new int[]{1, 2}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] count = new int[m][n];

            Deque<int[]> rottens = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        rottens.push(new int[]{i, j});
                        count[i][j] = 1;
                    }

                    if (grid[i][j] == 1) {
                        count[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            while (!rottens.isEmpty()) {
                int[] cur = rottens.pop();
                infect(cur[0] + 1, cur[1], grid, count, count[cur[0]][cur[1]], rottens);
                infect(cur[0] - 1, cur[1], grid, count, count[cur[0]][cur[1]], rottens);
                infect(cur[0], cur[1] + 1, grid, count, count[cur[0]][cur[1]], rottens);
                infect(cur[0], cur[1] - 1, grid, count, count[cur[0]][cur[1]], rottens);
            }

            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        if (count[i][j] == Integer.MAX_VALUE) return -1;
                        res = Math.max(res, count[i][j] - 1);
                    }
                }
            }

            return res;
        }

        void infect(int i, int j, int[][] grid, int[][] count, int step, Deque<int[]> rottens) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
            if (count[i][j] > step + 1) {
                count[i][j] = Math.min(step + 1, count[i][j]);
                rottens.push(new int[]{i, j});
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}