package questions.leetcode.editor.en;

//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// 
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 9062 👎 295


//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// 
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 9062 👎 295


import java.util.*;
import java.util.stream.Collectors;

public class Q131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new Q131PalindromePartitioning().new Solution();
        solution.partition("aanaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new LinkedList<>();

        String s;

        boolean[][] dp;

        public List<List<String>> partition(String s) {
            LinkedList<String> buf = new LinkedList<>();
            this.s = s;

            dp = new boolean[s.length()][s.length()];

            for (int l = 0; l < s.length(); l++) {
                for (int r = 0; r <= l; r++) {
                    if (s.charAt(l) == s.charAt(r) && (l - r <= 2 || dp[r + 1][l - 1])) {
                        dp[r][l] = true;
                    }
                }
            }

            fun(buf, 0);

            return res;
        }

        void fun(Deque<String> list, int start) {
            if (start == s.length()) {
                res.add(List.copyOf(list));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (dp[start][i]) {
                    list.addLast(s.substring(start, i + 1));
                    fun(list, i + 1);
                    list.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}