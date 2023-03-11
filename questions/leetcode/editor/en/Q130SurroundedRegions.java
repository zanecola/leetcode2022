package questions.leetcode.editor.en;

//Given an m x n matrix board containing 'X' and 'O', capture all regions that 
//are 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
//region. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//Explanation: Notice that an 'O' should not be flipped if:
//- It is on the border, or
//- It is adjacent to an 'O' that should not be flipped.
//The bottom 'O' is on the border, so it is not flipped.
//The other three 'O' form a surrounded region, so they are flipped.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 6696 👎 1462


//Given an m x n matrix board containing 'X' and 'O', capture all regions that 
//are 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
//region. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//Explanation: Notice that an 'O' should not be flipped if:
//- It is on the border, or
//- It is adjacent to an 'O' that should not be flipped.
//The bottom 'O' is on the border, so it is not flipped.
//The other three 'O' form a surrounded region, so they are flipped.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 6696 👎 1462


public class Q130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new Q130SurroundedRegions().new Solution();
        solution.solve(new char[][]{
                new char[]{'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                new char[]{'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                new char[]{'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
                new char[]{'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
                new char[]{'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;

        boolean[][] invalid;
        char[][] board;
        int m;
        int n;

        public void solve(char[][] board) {
            m = board.length;
            n = board[0].length;

            this.board = board;

            visited = new boolean[m][n];
            invalid = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        myFun(i, j);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O' && !invalid[i][j]) board[i][j] = 'X';
                }
            }
        }

        void myFun(int i, int j) {
            if (i < 0 || j < 0 || i == m || j == n) return;

            if (visited[i][j]) return;

            if (board[i][j] == 'O') {
                invalid[i][j] = true;
                visited[i][j] = true;
                myFun(i + 1, j);
                myFun(i, j + 1);
                myFun(i, j - 1);
                myFun(i - 1, j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}