package questions.leetcode.editor.en;

//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// Related Topics Array Binary Search Dynamic Programming 👍 16240 👎 298


//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// Related Topics Array Binary Search Dynamic Programming 👍 16240 👎 298


import java.util.ArrayDeque;
import java.util.Deque;

public class Q300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Q300LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;

            int[] tails = new int[nums.length];

            int t = 0;
            tails[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > tails[t]) {
                    t++;
                    tails[t] = nums[i];
                } else {
                    int index = bi(tails, 0, t, nums[i]);
                    tails[index] = nums[i];
                }
            }

            return t + 1;
        }

        int bi(int[] nums, int ll, int rr, int tar) { // find smallest larger one than tar
            int l = ll, r = rr;
            while (l < r) { // end cond: l + 1 == r OR l = r - 1
                int mid = (r - l) / 2 + l; // mid-left

                if (nums[mid] == tar) return mid;

                if (nums[mid] < tar) l = mid + 1;
                else r = mid;
            }

            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}