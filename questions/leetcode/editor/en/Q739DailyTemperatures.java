package questions.leetcode.editor.en;

//Given an array of integers temperatures represents the daily temperatures, 
//return an array answer such that answer[i] is the number of days you have to wait 
//after the iᵗʰ day to get a warmer temperature. If there is no future day for 
//which this is possible, keep answer[i] == 0 instead. 
//
// 
// Example 1: 
// Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
// 
// Example 2: 
// Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
// 
// Example 3: 
// Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
// 
// Constraints: 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics Array Stack Monotonic Stack 👍 10046 👎 232


//Given an array of integers temperatures represents the daily temperatures, 
//return an array answer such that answer[i] is the number of days you have to wait 
//after the iᵗʰ day to get a warmer temperature. If there is no future day for 
//which this is possible, keep answer[i] == 0 instead. 
//
// 
// Example 1: 
// Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
// 
// Example 2: 
// Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
// 
// Example 3: 
// Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
// 
// Constraints: 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics Array Stack Monotonic Stack 👍 10046 👎 232


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Q739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new Q739DailyTemperatures().new Solution();
        solution.dailyTemperatures(new int[]{3, 4, 5, 1, 0, 2, 6, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] t) {
            int[] res = new int[t.length];

            LinkedList<Integer> s = new LinkedList<>();

            int index = 0;

            while (index < t.length) {
                while (!s.isEmpty() && t[s.peek()] < t[index]) {
                    int l = s.pop();
                    res[l] = index - l;
                }

                s.push(index);

                index++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}