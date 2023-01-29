package questions.leetcode.editor.en;

//Given two strings text1 and text2, return the length of their longest common 
//subsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order 
//of the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both 
//strings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
//
// Related Topics String Dynamic Programming 👍 10058 👎 118


//Given two strings text1 and text2, return the length of their longest common 
//subsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order 
//of the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both 
//strings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
//
// Related Topics String Dynamic Programming 👍 10058 👎 118


public class Q1143LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new Q1143LongestCommonSubsequence().new Solution();
        solution.longestCommonSubsequence("bsbininm", "jmjkbkjkv");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] c1 = (" " + text1).toCharArray();
            char[] c2 = (" " + text2).toCharArray();

            int[][] dp = new int[c1.length][c2.length];

            for (int i = 1; i < c1.length; i++) {
                for (int j = 1; j < c2.length; j++) {
                    if (c1[i] == c2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            return dp[c1.length - 1][c2.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}