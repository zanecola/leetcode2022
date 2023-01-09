package questions.leetcode.editor.en;

//Given a collection of numbers, nums, that might contain duplicates, return 
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics Array Backtracking 👍 6918 👎 125


//Given a collection of numbers, nums, that might contain duplicates, return 
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics Array Backtracking 👍 6918 👎 125


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Q47PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        HashSet<Integer> used = new HashSet<>();
        int[] nums;

        public List<List<Integer>> permuteUnique(int[] nums) {
            this.nums = nums;

            Arrays.sort(nums);

            inner(new LinkedList<>());

            return res;
        }

        void inner(LinkedList<Integer> buf) {
            if (buf.size() == nums.length) {
                res.add(new LinkedList<>(buf));
                return;
            }

            for (int i = 0; i < nums.length; i++) {

                if (i > 0 && nums[i] == nums[i - 1] && !used.contains(i - 1)) continue;

                if (!used.contains(i)) {
                    buf.addLast(nums[i]);
                    used.add(i);

                    inner(buf);

                    buf.removeLast();
                    used.remove(i);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}