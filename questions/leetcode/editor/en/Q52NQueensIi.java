package questions.leetcode.editor.en;

//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return the number of distinct solutions to the n-queens 
//puzzle. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics Backtracking 👍 2999 👎 237


//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return the number of distinct solutions to the n-queens 
//puzzle. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics Backtracking 👍 2999 👎 237


import java.util.Arrays;
import java.util.HashSet;

public class Q52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new Q52NQueensIi().new Solution();
        solution.totalNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        int n;

        int[][] board;
        boolean[] cols;

        HashSet<Integer> dia;

        HashSet<Integer> rdia;

        public int totalNQueens(int n) {
            this.n = n;
            board = new int[n][n];
            cols = new boolean[n];
            dia = new HashSet<>();
            rdia = new HashSet<>();
            inner(0);
            return res;
        }

        void inner(int row) {
            if (row == n) {
                res++;
                return;
            }

            for (int j = 0; j < n; j++) {
                if (isValid(row, j)) {
                    board[row][j] = 1;
                    cols[j] = true;

                    dia.add(row - j);
                    rdia.add(j + row);
                    inner(row + 1);
                    board[row][j] = 0;
                    cols[j] = false;

                    dia.remove(row - j);
                    rdia.remove(j + row);
                }
            }
        }

        boolean isValid(int i, int j) {
            return !(cols[j] || dia.contains(i - j) || rdia.contains(j + i));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}