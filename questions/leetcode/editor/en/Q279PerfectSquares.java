package questions.leetcode.editor.en;

//Given an integer n, return the least number of perfect square numbers that 
//sum to n. 
//
// A perfect square is an integer that is the square of an integer; in other 
//words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics Math Dynamic Programming Breadth-First Search 👍 8981 👎 392


//Given an integer n, return the least number of perfect square numbers that 
//sum to n. 
//
// A perfect square is an integer that is the square of an integer; in other 
//words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics Math Dynamic Programming Breadth-First Search 👍 8981 👎 392


import java.util.*;

public class Q279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new Q279PerfectSquares().new Solution();
        solution.numSquares(12);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            ArrayList<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 100 && i * i <= n; i++) {
                list.add(i * i);
                set.add(i * i);
            }

            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int res = i;
                if (set.contains(i)) dp[i] = 1;
                else {
                    for (int j = 1; j < list.size() && list.get(j) < i; j++) {
                        if (dp[i - list.get(j)] + 1 < res) res = dp[i - list.get(j)] + 1;
                    }

                    dp[i] = res;
                }
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}