package questions.leetcode.editor.en;

//Given an array of points where points[i] = [xi, yi] represents a point on the 
//X-Y plane and an integer k, return the k closest points to the origin (0, 0). 
//
// The distance between two points on the X-Y plane is the Euclidean distance (
//i.e., √(x1 - x2)² + (y1 - y2)²). 
//
// You may return the answer in any order. The answer is guaranteed to be 
//unique (except for the order that it is in). 
//
// 
// Example 1: 
// 
// 
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [
//[-2,2]].
// 
//
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= points.length <= 10⁴ 
// -10⁴ < xi, yi < 10⁴ 
// 
//
// Related Topics Array Math Divide and Conquer Geometry Sorting Heap (Priority 
//Queue) Quickselect 👍 7219 👎 260


//Given an array of points where points[i] = [xi, yi] represents a point on the 
//X-Y plane and an integer k, return the k closest points to the origin (0, 0). 
//
// The distance between two points on the X-Y plane is the Euclidean distance (
//i.e., √(x1 - x2)² + (y1 - y2)²). 
//
// You may return the answer in any order. The answer is guaranteed to be 
//unique (except for the order that it is in). 
//
// 
// Example 1: 
// 
// 
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [
//[-2,2]].
// 
//
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= points.length <= 10⁴ 
// -10⁴ < xi, yi < 10⁴ 
// 
//
// Related Topics Array Math Divide and Conquer Geometry Sorting Heap (Priority 
//Queue) Quickselect 👍 7219 👎 260


public class Q973KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new Q973KClosestPointsToOrigin().new Solution();
        solution.kClosest(new int[][]{new int[]{1, 0}, new int[]{0, 1}}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            sort(points, 0, points.length - 1);

            int[][] res = new int[k][2];
            int i = 0;
            while (i < k) {
                res[i] = points[i++];
            }

            return res;
        }

        void sort(int[][] points, int left, int right) {
            if (left >= right) return;
            int l = left;
            int r = right;

            int mid = (r - l) / 2 + l;
            int p = distance(points[mid]);

            while (l < r) {
                while (distance(points[l]) < p) l++;
                while (distance(points[r]) > p) r--;

                if (l <= r) {
                    swap(points, l, r);
                    l++;
                    r--;
                }
            }
            sort(points, left, r);
            sort(points, l, right);
        }

        int distance(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }

        void swap(int[][] points, int i, int j) {
            var temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}