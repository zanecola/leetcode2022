package questions.leetcode.editor.en;

//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must solve it in O(n) time complexity. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 13007 👎 648


//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must solve it in O(n) time complexity. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 13007 👎 648


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Q215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new Q215KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return qs(nums, 0, nums.length - 1, k);
        }

        int qs(int[] nums, int l, int r, int k) {
            int rand = random.nextInt(r - l + 1) + l;
            swap(nums, rand, l);
            int pivot = nums[l];
            int le = l, ge = r;
            while (le < ge) {
                while (le < ge && nums[ge] >= pivot) ge--;

                swap(nums, le, ge);

                while (le < ge && nums[le] <= pivot) le++;

                swap(nums, le, ge);
            }

            if (le == nums.length - k) return nums[le];
            if (le > nums.length - k) return qs(nums, l, le - 1, k);
            return qs(nums, le + 1, r, k);
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}