package questions.leetcode.editor.en;

//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 8318 👎 971


//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 8318 👎 971


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18FourSum{
  public static void main(String[] args) {
       Solution solution = new Q18FourSum().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i ++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j ++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] > target && (nums[i] + nums[j] > 0)) break;

                int l = j + 1, r = nums.length - 1;

                while (l < r){
                    if(l > j + 1 && nums[l] == nums[l - 1]){
                        l ++;
                        continue;
                    }
                    if (r < nums.length - 1 && nums[r] == nums[r + 1]){
                        r --;
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[l] + nums[r] == target){
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l ++;
                        r --;
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[l] + nums[r] > target){
                        r --;
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[l] + nums[r] < target){
                        l ++;
                        continue;
                    }
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}