package questions.leetcode.editor.en;

//An image is represented by an m x n integer grid image where image[i][j] 
//represents the pixel value of the image. 
//
// You are also given three integers sr, sc, and color. You should perform a 
//flood fill on the image starting from the pixel image[sr][sc]. 
//
// To perform a flood fill, consider the starting pixel, plus any pixels 
//connected 4-directionally to the starting pixel of the same color as the starting 
//pixel, plus any pixels connected 4-directionally to those pixels (also with the same 
//color), and so on. Replace the color of all of the aforementioned pixels with 
//color. 
//
// Return the modified image after performing the flood fill. 
//
// 
// Example 1: 
// 
// 
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.
//e., the red pixel), all pixels connected by a path of the same color as the 
//starting pixel (i.e., the blue pixels) are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally 
//connected to the starting pixel.
// 
//
// Example 2: 
//
// 
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//Output: [[0,0,0],[0,0,0]]
//Explanation: The starting pixel is already colored 0, so no changes are made 
//to the image.
// 
//
// 
// Constraints: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], color < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 6723 ?
//? 673


//An image is represented by an m x n integer grid image where image[i][j] 
//represents the pixel value of the image. 
//
// You are also given three integers sr, sc, and color. You should perform a 
//flood fill on the image starting from the pixel image[sr][sc]. 
//
// To perform a flood fill, consider the starting pixel, plus any pixels 
//connected 4-directionally to the starting pixel of the same color as the starting 
//pixel, plus any pixels connected 4-directionally to those pixels (also with the same 
//color), and so on. Replace the color of all of the aforementioned pixels with 
//color. 
//
// Return the modified image after performing the flood fill. 
//
// 
// Example 1: 
// 
// 
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.
//e., the red pixel), all pixels connected by a path of the same color as the 
//starting pixel (i.e., the blue pixels) are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally 
//connected to the starting pixel.
// 
//
// Example 2: 
//
// 
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//Output: [[0,0,0],[0,0,0]]
//Explanation: The starting pixel is already colored 0, so no changes are made 
//to the image.
// 
//
// 
// Constraints: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], color < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 6723 ?
//? 673


public class Q733FloodFill {
    public static void main(String[] args) {
        Solution solution = new Q733FloodFill().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        int[][] board;
        int m;
        int n;
        int color;
        int start;


        public int[][] floodFill(int[][] board, int sr, int sc, int color) {
            m = board.length;
            n = board[0].length;

            this.board = board;

            visited = new boolean[m][n];

            this.color = color;
            start = board[sr][sc];

            myFun(sr, sc);

            return board;
        }

        void myFun(int i, int j) {
            if (i < 0 || j < 0 || i == m || j == n) return;

            if (visited[i][j]) return;

            if (board[i][j] == start) {
                board[i][j] = color;
                visited[i][j] = true;
                myFun(i + 1, j);
                myFun(i, j + 1);
                myFun(i, j - 1);
                myFun(i - 1, j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}