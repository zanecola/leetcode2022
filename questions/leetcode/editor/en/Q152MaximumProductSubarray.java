package questions.leetcode.editor.en;

//Given an integer array nums, find a subarray that has the largest product, 
//and return the product. 
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// Related Topics Array Dynamic Programming 👍 14889 👎 442


//Given an integer array nums, find a subarray that has the largest product, 
//and return the product. 
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// Related Topics Array Dynamic Programming 👍 14889 👎 442


import java.util.ArrayList;
import java.util.List;

public class Q152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new Q152MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int res = nums[0];

            int[] mins = new int[nums.length];
            int[] maxs = new int[nums.length];

            mins[0] = nums[0];
            maxs[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (mins[i-1] == 0) {
                    mins[i-1] = 1;
                }

                if (maxs[i-1] == 0) {
                    maxs[i-1] = 1;
                }

                maxs[i] = Math.max(Math.max(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]), nums[i]);
                mins[i] = Math.min(Math.min(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]), nums[i]);

                res = Math.max(maxs[i], res);
            }

            res = Math.max(maxs[nums.length-1], res);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}