package questions.leetcode.editor.en;

//Given an integer array nums of length n and an integer target, find three 
//integers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 500 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 8260 👎 455


//Given an integer array nums of length n and an integer target, find three 
//integers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 500 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 8260 👎 455


import java.util.Arrays;

public class Q16ThreeSumClosest{
  public static void main(String[] args) {
       Solution solution = new Q16ThreeSumClosest().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i ++){
            if (i > 1 && nums[i] == nums[i - 1]){
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j ++){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                for (int k = j +1; k < nums.length; k ++){
                    if (k > j + 1 && nums[k] == nums[k - 1]){
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}