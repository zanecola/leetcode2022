package questions.leetcode.editor.en;

//We have n jobs, where every job is scheduled to be done from startTime[i] to 
//endTime[i], obtaining a profit of profit[i]. 
//
// You're given the startTime, endTime and profit arrays, return the maximum 
//profit you can take such that there are no two jobs in the subset with overlapping 
//time range. 
//
// If you choose a job that ends at time X you will be able to start another 
//job that starts at time X. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job. 
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
// 
//
// Example 2: 
//
// 
//
// 
//Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70
//,60]
//Output: 150
//Explanation: The subset chosen is the first, fourth and fifth job. 
//Profit obtained 150 = 20 + 70 + 60.
// 
//
// Example 3: 
//
// 
//
// 
//Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10⁴ 
// 1 <= startTime[i] < endTime[i] <= 10⁹ 
// 1 <= profit[i] <= 10⁴ 
// 
//
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 4930 👎 56


//We have n jobs, where every job is scheduled to be done from startTime[i] to 
//endTime[i], obtaining a profit of profit[i]. 
//
// You're given the startTime, endTime and profit arrays, return the maximum 
//profit you can take such that there are no two jobs in the subset with overlapping 
//time range. 
//
// If you choose a job that ends at time X you will be able to start another 
//job that starts at time X. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job. 
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
// 
//
// Example 2: 
//
// 
//
// 
//Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70
//,60]
//Output: 150
//Explanation: The subset chosen is the first, fourth and fifth job. 
//Profit obtained 150 = 20 + 70 + 60.
// 
//
// Example 3: 
//
// 
//
// 
//Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10⁴ 
// 1 <= startTime[i] < endTime[i] <= 10⁹ 
// 1 <= profit[i] <= 10⁴ 
// 
//
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 4930 👎 56


import java.util.Arrays;

public class Q1235MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        Solution solution = new Q1235MaximumProfitInJobScheduling().new Solution();
        solution.jobScheduling(new int[]{4, 3, 1, 2, 4, 8, 3, 3, 3, 9}, new int[]{5, 6, 3, 5, 9, 9, 8, 5, 7, 10}, new int[]{9, 9, 5, 12, 10, 11, 10, 4, 14, 7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int[][] jobs = new int[startTime.length + 1][3];
            jobs[0] = new int[]{0, 0, 0};

            for (int i = 0; i < startTime.length; i++) {
                jobs[i + 1] = new int[]{startTime[i], endTime[i], profit[i]};
            }

            Arrays.sort(jobs, (j1, j2) -> j1[1] - j2[1]);

            int[] dp = new int[startTime.length + 1];

            dp[0] = 0;

            for (int i = 1; i < startTime.length + 1; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i]);

                dp[i] = Math.max(dp[i], jobs[i][2] + dp[find(jobs, jobs[i][0])]);
            }

            return dp[startTime.length];
        }

        private int find(int[][] jobs, int tar) {
            int lo = 0;
            int hi = jobs.length - 1;

            while (lo < hi) {
                int mid = (hi + lo + 1) / 2;
                if (jobs[mid][1] > tar) {
                    hi = mid - 1;
                } else if (jobs[mid][1] <= tar) {
                    lo = mid;
                }
            }

            return lo;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}