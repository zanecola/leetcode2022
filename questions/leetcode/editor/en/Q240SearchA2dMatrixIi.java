package questions.leetcode.editor.en;

//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search Divide and Conquer Matrix 👍 9885 👎 165


//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search Divide and Conquer Matrix 👍 9885 👎 165


public class Q240SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new Q240SearchA2dMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int mm = 0, nn = n - 1;

            while (mm < m && nn >= 0) {
                if (matrix[mm][nn] == target) return true;
                if (matrix[mm][nn] > target) nn--;
                else mm++;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}