package questions.leetcode.editor.en;

//Given an integer array nums, return an array answer such that answer[i] is 
//equal to the product of all the elements of nums except nums[i]. 
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
//
// You must write an algorithm that runs in O(n) time and without using the 
//division operation. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// 
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The 
//output array does not count as extra space for space complexity analysis.) 
//
// Related Topics Array Prefix Sum 👍 16164 👎 899


//Given an integer array nums, return an array answer such that answer[i] is 
//equal to the product of all the elements of nums except nums[i]. 
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
//
// You must write an algorithm that runs in O(n) time and without using the 
//division operation. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// 
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The 
//output array does not count as extra space for space complexity analysis.) 
//
// Related Topics Array Prefix Sum 👍 16164 👎 899


public class Q238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new Q238ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            left[0] = nums[0];
            right[nums.length - 1] = nums[nums.length - 1];

            for (int i = 1; i < nums.length; i++) {
                left[i] = nums[i] * left[i - 1];
                right[nums.length - 1 - i] = nums[nums.length - 1 - i] * right[nums.length - i];
            }

            int[] res = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                int l = i == 0 ? 1 : left[i - 1];
                int r = i == nums.length - 1 ? 1 : right[i + 1];

                res[i] = l * r;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}