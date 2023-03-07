package questions.leetcode.editor.en;

//Implement pow(x, n), which calculates x raised to the power n (i.e., xⁿ). 
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2⁻² = 1/2² = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// n is an integer. 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// Related Topics Math Recursion 👍 6785 👎 7090


//Implement pow(x, n), which calculates x raised to the power n (i.e., xⁿ). 
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2⁻² = 1/2² = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// n is an integer. 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// Related Topics Math Recursion 👍 6785 👎 7090


public class Q50PowxN {
    public static void main(String[] args) {
        Solution solution = new Q50PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            return myFun(x, n);
//            int neg = 1;
//            if (n < 0) {
//                neg = -1;
//                n = -n;
//            }
//
//            double res = myFun(x, n);
//            return neg == 1 ? res : 1 / res;
        }

        public double myFun(double x, int n) {
            if (n == -1) return 1 / x;
            if (n == -2) return 1 / (x * x);
            if (n == 0) return 1;
            if (n == 1) return x;
            if (n == 2) return x * x;

            int bi = n / 2;
            int res = n % 2;

            double xtobi = myFun(x, bi);

            return xtobi * xtobi * myFun(x, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}