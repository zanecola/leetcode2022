package questions.leetcode.editor.en;

//Given an array of integers heights representing the histogram's bar height 
//where the width of each bar is 1, return the area of the largest rectangle in the 
//histogram. 
//
// 
// Example 1: 
// 
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
// 
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics Array Stack Monotonic Stack 👍 13098 👎 185


//Given an array of integers heights representing the histogram's bar height 
//where the width of each bar is 1, return the area of the largest rectangle in the 
//histogram. 
//
// 
// Example 1: 
// 
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
// 
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics Array Stack Monotonic Stack 👍 13098 👎 185


import java.util.Stack;

public class Q84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new Q84LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{1, 2, 3, 4, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> s = new Stack<>();
            int[] left = new int[heights.length];
            int[] right = new int[heights.length];
            int res = 0;

            s.push(-1);

            for (int i = 0; i < heights.length; i++) {
                while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
                    s.pop();
                }

                left[i] = s.peek();
                s.push(i);
            }

            s.clear();
            s.push(heights.length);

            for (int i = heights.length - 1; i >= 0; i--) {
                while (s.peek() != heights.length && heights[s.peek()] >= heights[i]) {
                    s.pop();
                }

                right[i] = s.peek();
                s.push(i);
            }

            for (int i = 0; i < heights.length; i++) {
                res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}