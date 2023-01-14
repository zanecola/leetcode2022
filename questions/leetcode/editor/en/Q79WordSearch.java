package questions.leetcode.editor.en;

//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
//
// Related Topics Array Backtracking Matrix 👍 12514 👎 503


//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
//
// Related Topics Array Backtracking Matrix 👍 12514 👎 503


public class Q79WordSearch {
    public static void main(String[] args) {
        Solution solution = new Q79WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] c;
        char[][] board;
        boolean[][] visited;
        int m;
        int n;
        boolean res;


        public boolean exist(char[][] board, String word) {
            c = word.toCharArray();
            this.board = board;
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == c[0]) {
                        bt(i, j, 0);
                    }
                }
            }

            return res;
        }

        void bt(int i, int j, int k) {
            if (k == c.length) {
                res = true;
                return;
            }

            if (res) {
                return;
            }

            if (i < 0 || j < 0 || i >= m || j >= n) return;

            if (visited[i][j]) return;

            if (board[i][j] == c[k]) {
                visited[i][j] = true;
                bt(i + 1, j, k + 1);
                bt(i - 1, j, k + 1);
                bt(i, j + 1, 1 + k);
                bt(i, j - 1, 1 + k);
                visited[i][j] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}