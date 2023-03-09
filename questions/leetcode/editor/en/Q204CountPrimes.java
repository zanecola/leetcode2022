package questions.leetcode.editor.en;

//Given an integer n, return the number of prime numbers that are strictly less 
//than n. 
//
// 
// Example 1: 
//
// 
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
//
// Related Topics Array Math Enumeration Number Theory 👍 6526 👎 1247


//Given an integer n, return the number of prime numbers that are strictly less 
//than n. 
//
// 
// Example 1: 
//
// 
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
//
// Related Topics Array Math Enumeration Number Theory 👍 6526 👎 1247


import java.util.HashSet;

public class Q204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new Q204CountPrimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] set = new boolean[n + 1];
            int res = 0;
            for (int i = 2; i < n; i++) {
                if (!set[i]) {
                    res++;
                }

                set[i] = true;

                for (long j = (long) i * i; j < n; j += i) {
                    set[(int) j] = true;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}