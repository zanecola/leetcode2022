package questions.leetcode.editor.en;

//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
//
// Related Topics Array Backtracking Bit Manipulation 👍 13258 👎 187


//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
//
// Related Topics Array Backtracking Bit Manipulation 👍 13258 👎 187


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78Subsets {
    public static void main(String[] args) {
        Solution solution = new Q78Subsets().new Solution();
        solution.subsets(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums;

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;

            bt(0, new
                    LinkedList<>());

            return res;
        }

        void bt(int ii, LinkedList<Integer> list) {
            res.add(new ArrayList<>(list));
            for (int i = ii; i < nums.length; i++) {
                list.addLast(nums[i]);
                bt(i + 1, list);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}