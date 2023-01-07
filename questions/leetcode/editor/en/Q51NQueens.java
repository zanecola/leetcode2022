package questions.leetcode.editor.en;

//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics Array Backtracking 👍 9109 👎 203


//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics Array Backtracking 👍 9109 👎 203


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Q51NQueens {
    public static void main(String[] args) {
        Solution solution = new Q51NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> dia = new HashSet<>();
        HashSet<Integer> rdia = new HashSet<>();

        int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            char[][] board = new char[n][n];
            for (var row : board) {
                Arrays.fill(row, '.');
            }

            backTrack(0, board);

            return res;
        }

        void backTrack(int row, char[][] board) {
            if (row == n) {
                res.add(Arrays.stream(board).map(String::new).toList());
                return;
            }

            for (int i = 0; i < n; i++) {
                if (cols.contains(i) || dia.contains(row - i) || rdia.contains(row + i)) continue;

                board[row][i] = 'Q';
                cols.add(i);
                dia.add(row - i);
                rdia.add(row + i);

                backTrack(row + 1, board);

                board[row][i] = '.';
                cols.remove(i);
                dia.remove(row - i);
                rdia.remove(row + i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}