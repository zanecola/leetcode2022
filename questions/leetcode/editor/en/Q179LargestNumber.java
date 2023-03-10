package questions.leetcode.editor.en;

//Given a list of non-negative integers nums, arrange them such that they form 
//the largest number and return it. 
//
// Since the result may be very large, so you need to return a string instead 
//of an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array String Greedy Sorting 👍 6602 👎 542


//Given a list of non-negative integers nums, arrange them such that they form 
//the largest number and return it. 
//
// Since the result may be very large, so you need to return a string instead 
//of an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array String Greedy Sorting 👍 6602 👎 542


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Q179LargestNumber {
    public static void main(String[] args) {
        Solution solution = new Q179LargestNumber().new Solution();
        solution.largestNumber(new int[]{33, 30, 34, 5, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            Queue<String> queue = new PriorityQueue<>(
                    (a, b) -> {
                        return -(a + b).compareTo(b + a);
                    }
            );

            for (int i : nums) {
                queue.add(Integer.toString(i));
            }

            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                sb.append(queue.poll());
            }

            String res = sb.toString();
            int i = 0;
            for (; i < res.length(); i++) {
                if (res.charAt(i) != '0') break;
            }

            return res.substring(i).equals("") ? "0" : res.substring(i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}