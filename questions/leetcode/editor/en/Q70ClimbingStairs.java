package questions.leetcode.editor.en;

//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics Math Dynamic Programming Memoization 👍 16599 👎 503


//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics Math Dynamic Programming Memoization 👍 16599 👎 503


import java.util.HashMap;
import java.util.Map;

public class Q70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q70ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> m = new HashMap<>();

        public int climbStairs(int n) {
            if (n <= 0) return 0;
            if (n <= 2) return n;

            int n1 = 0, n2 = 0;

            if (m.containsKey(n - 1)){
                n1 = m.get(n-1);
            } else {
                n1 = climbStairs(n - 1);
                m.put(n-1, n1);
            }

            if (m.containsKey(n - 2)){
                n2 = m.get(n-2);
            } else {
                n2 = climbStairs(n - 2);
                m.put(n-2, n2);
            }
            return n1 + n2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}