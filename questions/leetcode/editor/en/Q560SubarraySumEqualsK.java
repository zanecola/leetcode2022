package questions.leetcode.editor.en;

//Given an array of integers nums and an integer k, return the total number of 
//subarrays whose sum equals to k. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// 
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics Array Hash Table Prefix Sum 👍 17075 👎 501


//Given an array of integers nums and an integer k, return the total number of 
//subarrays whose sum equals to k. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// 
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics Array Hash Table Prefix Sum 👍 17075 👎 501


public class Q560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new Q560SubarraySumEqualsK().new Solution();
        solution.subarraySum(new int[]{1, 1, 1}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int res = 0;
            int sum = 0;

            for (int l = 0, r = 0; r < nums.length; r++) {
                sum += nums[r];

                if (sum > k) {
                    while (sum > k && l < r) {
                        sum -= nums[l];
                        l++;
                    }
                }
                if (sum == k) res++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}