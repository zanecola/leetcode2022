package questions.leetcode.editor.en;

//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics Array 👍 8031 👎 555


//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics Array 👍 8031 👎 555


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q57InsertInterval {
    public static void main(String[] args) {
        Solution solution = new Q57InsertInterval().new Solution();
        solution.insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}}, new int[]{2, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals == null || intervals.length == 0) return new int[][]{newInterval};
            List<int[]> res = new LinkedList<>();

            int prevStart = -1;
            int prevClose = -1;
            boolean inserted = false;

            for (int[] ints : intervals) {
                if (inserted) {
                    res.add(ints);
                } else if (ints[1] < newInterval[0]) {
                    res.add(ints);
                } else {
                    if (prevStart == -1) {
                        if (ints[0] > newInterval[1]) {
                            res.add(newInterval);
                            res.add(ints);
                            inserted = true;
                        } else {
                            prevStart = Math.min(ints[0], newInterval[0]);
                            prevClose = Math.max(ints[1], newInterval[1]);
                        }
                    } else {
                        if (ints[0] <= prevClose) {
                            prevClose = Math.max(ints[1], newInterval[1]);
                        } else {
                            res.add(new int[]{prevStart, prevClose});
                            res.add(ints);
                            inserted = true;
                        }
                    }
                }
            }

            if (!inserted) {
                if (prevClose != -1) {
                    res.add(new int[]{prevStart, prevClose});
                } else {
                    res.add(newInterval);
                }
            }

            return res.toArray(new int[res.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}