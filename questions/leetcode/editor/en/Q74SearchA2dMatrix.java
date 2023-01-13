package questions.leetcode.editor.en;

//You are given an m x n integer matrix matrix with the following two 
//properties: 
//
// 
// Each row is sorted in non-decreasing order. 
// The first integer of each row is greater than the last integer of the 
//previous row. 
// 
//
// Given an integer target, return true if target is in matrix or false 
//otherwise. 
//
// You must write a solution in O(log(m * n)) time complexity. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics Array Binary Search Matrix 👍 11003 👎 325


//You are given an m x n integer matrix matrix with the following two 
//properties: 
//
// 
// Each row is sorted in non-decreasing order. 
// The first integer of each row is greater than the last integer of the 
//previous row. 
// 
//
// Given an integer target, return true if target is in matrix or false 
//otherwise. 
//
// You must write a solution in O(log(m * n)) time complexity. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics Array Binary Search Matrix 👍 11003 👎 325


public class Q74SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new Q74SearchA2dMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;

            int l = 0, r = m - 1;

            if (m > 1) {
                while (l < r) {
                    int mid = (r - l + 1) / 2 + l; // left-mid

                    if (matrix[mid][0] == target) return true;

                    if (matrix[mid][0] > target) {
                        r = mid - 1;
                    } else {
                        l = mid;
                    }
                }
            }


            int i = l;

            l = 0;
            r = n - 1;

            while (l < r) {
                int mi = (r - l) / 2 + l;

                if (matrix[i][mi] == target) return true;

                if (matrix[i][mi] > target) {
                    r = mi;
                } else {
                    l = mi + 1;
                }
            }

            return matrix[i][l] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}