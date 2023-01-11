package questions.leetcode.editor.en;

//Given a sorted array of distinct integers and a target value, return the 
//index if the target is found. If not, return the index where it would be if it were 
//inserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,6], target = 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3,5,6], target = 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums contains distinct values sorted in ascending order. 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Binary Search 👍 11162 👎 518


//Given a sorted array of distinct integers and a target value, return the 
//index if the target is found. If not, return the index where it would be if it were 
//inserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,6], target = 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3,5,6], target = 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums contains distinct values sorted in ascending order. 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Binary Search 👍 11162 👎 518


public class Q35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Q35SearchInsertPosition().new Solution();
        solution.searchInsert(new int[]{1, 3, 5, 6}, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0, r = nums.length - 1, min = Integer.MAX_VALUE, mini = -1;

            while (l <= r) {
                int mid = (r - l) / 2 + l;

                if (nums[mid] == target) return mid;

                if (Math.abs(nums[mid] - target) < min) {
                    min = Math.abs(nums[mid] - target);
                    mini = mid;
                }

                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (nums[mini] > target) return mini;
            else return mini + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}