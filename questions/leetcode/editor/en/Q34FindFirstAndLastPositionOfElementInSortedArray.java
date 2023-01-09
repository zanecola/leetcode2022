package questions.leetcode.editor.en;

//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 15306 👎 365


//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 15306 👎 365


public class Q34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{5, 7, 7, 8, 8, 9}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] res = new int[]{-1, -1};
        int[] nums;
        int target;

        public int[] searchRange(int[] nums, int target) {
            this.nums = nums;
            this.target = target;

            findFirst(0, nums.length - 1);
            findLast(0, nums.length - 1);

            return res;
        }

        void findFirst(int l, int r) {
            if (l > r) return;

            int mid = (r - l) / 2 + l;

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                res[0] = mid;
                return;
            }

            if (nums[mid] >= target) {
                findFirst(l, mid - 1);
            } else {
                findFirst(mid + 1, r);
            }
        }

        void findLast(int l, int r) {
            if (l > r) return;

            int mid = (r - l) / 2 + l;

            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                res[1] = mid;
                return;
            }

            if (nums[mid] > target) {
                findLast(l, mid - 1);
            } else {
                findLast(mid + 1, r);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}