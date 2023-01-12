package questions.leetcode.editor.en;

//Given two strings word1 and word2, return the minimum number of operations 
//required to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 10810 👎 125


//Given two strings word1 and word2, return the minimum number of operations 
//required to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 10810 👎 125


public class Q72EditDistance {
    public static void main(String[] args) {
        Solution solution = new Q72EditDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] w1 = (" " + word1).toCharArray(), w2 = (" " + word2).toCharArray();

            int[][] board = new int[w1.length][w2.length];

            for (int i = 0; i < w1.length; i++) {
                board[i][0] = i;
            }

            for (int i = 0; i < w2.length; i++) {
                board[0][i] = i;
            }

            for (int i = 1; i < w1.length; i++) {
                for (int j = 1; j < w2.length; j++) {
                    if (w1[i] == w2[j]) board[i][j] = board[i - 1][j - 1];
                    else board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                }
            }

            return board[w1.length - 1][w2.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}