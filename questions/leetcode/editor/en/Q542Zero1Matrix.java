package questions.leetcode.editor.en;

//Given an m x n binary matrix mat, return the distance of the nearest 0 for 
//each cell. 
//
// The distance between two adjacent cells is 1. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
// 
//
// Example 2: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// There is at least one 0 in mat. 
// 
//
// Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 6712 
//👎 318


//Given an m x n binary matrix mat, return the distance of the nearest 0 for 
//each cell. 
//
// The distance between two adjacent cells is 1. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
// 
//
// Example 2: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// There is at least one 0 in mat. 
// 
//
// Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 6712 
//👎 318


import java.util.LinkedList;
import java.util.Queue;

public class Q542Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Q542Zero1Matrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m;
        int n;
        int[][] mat;
        boolean[][] visited;

        public int[][] updateMatrix(int[][] mat) {
            this.mat = mat;
            m = mat.length;
            n = mat[0].length;
            visited = new boolean[m][n];
            int[][] res = new int[m][n];
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        visited[i][j] = true;
                        my(i + 1, j, queue);
                        my(i - 1, j, queue);
                        my(i, j + 1, queue);
                        my(i, j - 1, queue);
                    }
                }
            }

            int step = 1;
            int qSize = queue.size();
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                qSize--;

                res[cur[0]][cur[1]] = step;
                visited[i][j] = true;
                my(i + 1, j, queue);
                my(i - 1, j, queue);
                my(i, j + 1, queue);
                my(i, j - 1, queue);

                if (qSize == 0) {
                    step++;
                    qSize = queue.size();
                }
            }

            return res;
        }

        void my(int i, int j, Queue<int[]> queue) {
            if (i < 0 || j < 0 || i == m || j == n || visited[i][j]) return;

            if (mat[i][j] == 1) {
                queue.add(new int[]{i, j});
                visited[i][j] = true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}