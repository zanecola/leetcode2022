package questions.leetcode.editor.en;

//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 24531 👎 343


//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 24531 👎 343


public class Q42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Q42TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int hi = 0;
            int running = 0;
            int res = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] >= height[hi]) {
                    res += running;
                    running = 0;
                    hi = i;
                } else {
                    running += (height[hi] - height[i]);
                }
            }

            running = 0;

            int newhi = height.length - 1;

            for (int i = height.length - 1; i >= hi; i--) {
                if (height[i] >= height[newhi]) {
                    res += running;
                    running = 0;
                    newhi = i;
                } else {
                    running += (height[newhi] - height[i]);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}