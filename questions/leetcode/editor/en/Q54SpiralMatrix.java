package questions.leetcode.editor.en;

//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics Array Matrix Simulation 👍 10072 👎 979


//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics Array Matrix Simulation 👍 10072 👎 979


import java.util.LinkedList;
import java.util.List;

public class Q54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new Q54SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int[][] directions = new int[][]{
                    {0, 1}, {1, 0}, {0, -1}, {-1, 0}
            };

            int m = matrix.length, n = matrix[0].length;

            boolean[][] visited = new boolean[m][n];

            List<Integer> res = new LinkedList<>();


            int count = 0, i = 0, j = 0, d = 0;

            while (count < n * m) {
                if (!visited[i][j]) {
                    res.add(matrix[i][j]);
                    visited[i][j] = true;
                }

                int[] curD = directions[d % 4];
                int newi = i + curD[0], newj = j + curD[1];

                if (newi < 0 || newj < 0 || newi >= m || newj >= n || visited[newi][newj]) {
                    d++;
                    curD = directions[d % 4];
                    newi = i + curD[0];
                    newj = j + curD[1];
                }

                i = newi;
                j = newj;
                count++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}