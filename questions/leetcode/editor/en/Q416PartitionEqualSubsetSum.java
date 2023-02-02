package questions.leetcode.editor.en;

//Given an integer array nums, return true if you can partition the array into 
//two subsets such that the sum of the elements in both subsets is equal or false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics Array Dynamic Programming 👍 9750 👎 165


//Given an integer array nums, return true if you can partition the array into 
//two subsets such that the sum of the elements in both subsets is equal or false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics Array Dynamic Programming 👍 9750 👎 165


import java.util.Arrays;

public class Q416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new Q416PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{1, 2, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean res = false;

        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();

            if (sum % 2 == 1) return false;
            sum /= 2;
            boolean[] dp = new boolean[sum + 1];


            for (int i = 1; i < nums.length; i++) {
                for (int j = sum; j > 0 && j >= nums[i]; j--) {
                    if (j == nums[i]) {
                        dp[j] = true;
                        continue;
                    }

                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }

            return dp[sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}