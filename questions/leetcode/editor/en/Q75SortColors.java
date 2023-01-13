package questions.leetcode.editor.en;

//Given an array nums with n objects colored red, white, or blue, sort them in-
//place so that objects of the same color are adjacent, with the colors in the 
//order red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and 
//blue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant 
//extra space? 
//
// Related Topics Array Two Pointers Sorting 👍 13528 👎 490


//Given an array nums with n objects colored red, white, or blue, sort them in-
//place so that objects of the same color are adjacent, with the colors in the 
//order red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and 
//blue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant 
//extra space? 
//
// Related Topics Array Two Pointers Sorting 👍 13528 👎 490


public class Q75SortColors {
    public static void main(String[] args) {
        Solution solution = new Q75SortColors().new Solution();
        solution.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int l = 0, r = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0 && l < nums.length) {
                    swap(nums, l++, i);
                }
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == 2 && r >= 0) {
                    swap(nums, r--, i);
                }
            }
        }

        void swap(int[] nums, int l, int r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}