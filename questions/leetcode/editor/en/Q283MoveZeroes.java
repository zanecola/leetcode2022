package questions.leetcode.editor.en;

//Given an integer array nums, move all 0's to the end of it while maintaining 
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// 
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done?
//
// Related Topics Array Two Pointers 👍 12503 👎 317


//Given an integer array nums, move all 0's to the end of it while maintaining 
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// 
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done?
//
// Related Topics Array Two Pointers 👍 12503 👎 317


public class Q283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new Q283MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0, j = 0;
            while (i < nums.length && nums[i] != 0) {
                i++;
            }

            if (i >= nums.length) return;

            j = i + 1;
            while (j < nums.length) {
                if(nums[j] != 0){
                    swap(nums, i, j);
                    i++;
                }
                j++;
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