package questions.leetcode.editor.en;

//Given the root of a binary tree and an integer targetSum, return the number 
//of paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
// 
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics Tree Depth-First Search Binary Tree 👍 9187 👎 442


//Given the root of a binary tree and an integer targetSum, return the number 
//of paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
// 
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics Tree Depth-First Search Binary Tree 👍 9187 👎 442


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new Q437PathSumIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int res = 0;
        int tar;

        public int pathSum(TreeNode root, int targetSum) {
            tar = targetSum;
            ArrayList<Long> s = new ArrayList<>();

            dfs(s, root);

            return res;
        }

        void dfs(ArrayList<Long> s, TreeNode node) {
            if (node == null) return;

            if (node.val == tar) res++;

            for (int i = 0; i < s.size(); i++) {
                long temp = s.get(i) + node.val;
                System.out.println(temp);
                if (tar == temp) res++;
                s.set(i, temp);
            }

            s.add((long)node.val);

            dfs(s, node.left);
            dfs(s, node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}