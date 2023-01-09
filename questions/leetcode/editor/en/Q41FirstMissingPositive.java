package questions.leetcode.editor.en;

//Given an unsorted integer array nums, return the smallest missing positive 
//integer. 
//
// You must implement an algorithm that runs in O(n) time and uses constant 
//extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
// 
//
// Example 3: 
//
// 
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics Array Hash Table 👍 12837 👎 1525


//Given an unsorted integer array nums, return the smallest missing positive 
//integer. 
//
// You must implement an algorithm that runs in O(n) time and uses constant 
//extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
// 
//
// Example 3: 
//
// 
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics Array Hash Table 👍 12837 👎 1525


public class Q41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new Q41FirstMissingPositive().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;

        public int firstMissingPositive(int[] nums) {
            this.nums = nums;

            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1 && nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                    swap(i, nums[i] - 1);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) return i + 1;
            }

            return nums.length + 1;
        }

        void swap(int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}