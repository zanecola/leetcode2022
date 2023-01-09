package questions.leetcode.editor.en;

//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// 
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Binary Search 👍 19280 👎 1162


//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// 
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Binary Search 👍 19280 👎 1162


public class Q33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q33SearchInRotatedSortedArray().new Solution();
        solution.search(new int[]{4,5,6,7,0,1,2}, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = -1;
        int[] nums;

        int target;

        public int search(int[] nums, int target) {
            this.nums = nums;
            this.target = target;

            inner(0, nums.length - 1);
            return res;
        }

        void inner(int l, int r) {
            if (l > r) {
                return;
            }

            if (l == r){
                if (nums[l] == target) res = l;
                return;
            }

            if ((nums[l] <= target && nums[r] >= target) ||(nums[l] > nums[r])){

            } else {
                return;
            }

            if ((nums[l] <= target && nums[r] >= target) ||(nums[l] > nums[r])){

            } else {
                return;
            }



            int mid = (r - l)/2 + l;

            if (nums[mid] == target){
                this.res = mid;
                return;
            }

            inner(mid + 1, r);
            inner(l, mid);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}