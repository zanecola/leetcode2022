package questions.leetcode.editor.en;

//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-
//boxes of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5
//",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".
//",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".
//","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5
//"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is 
//shown below:
// 
//
//
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
//
// Related Topics Array Backtracking Matrix 👍 7174 👎 191


//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-
//boxes of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5
//",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".
//",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".
//","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5
//"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is 
//shown below:
// 
//
//
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
//
// Related Topics Array Backtracking Matrix 👍 7174 👎 191


import java.util.ArrayList;
import java.util.List;

public class Q37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new Q37SudokuSolver().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][][] nums;
        boolean[][] rows;
        boolean[][] cols;
        char[][] board;

        boolean finished = false;

        List<List<Integer>> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            this.board = board;

            nums = new boolean[3][3][10];
            rows = new boolean[9][10];
            cols = new boolean[9][10];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0';
                        nums[i / 3][j / 3][num] = true;
                        rows[i][num] = true;
                        cols[j][num] = true;
                    } else {
                        spaces.add(List.of(i, j));
                    }
                }
            }

            backtrack(0);
        }

        void backtrack(int p) {
            if (p == spaces.size()) {
                finished = true;
                return;
            }

            var curPos = spaces.get(p);
            int i = curPos.get(0), j = curPos.get(1);

            for (int k = 1; k < 10; k++) {
                if (finished) return;
                if (nums[i / 3][j / 3][k] || rows[i][k] || cols[j][k]) {
                    continue;
                } else {
                    nums[i / 3][j / 3][k] = true;
                    rows[i][k] = true;
                    cols[j][k] = true;
                    board[i][j] = (char) (k + '0');

                    backtrack(p + 1);

                    nums[i / 3][j / 3][k] = false;
                    rows[i][k] = false;
                    cols[j][k] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}