package questions.leetcode.editor.en;

//Given the root of a binary tree, return the level order traversal of its 
//nodes' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 12041 👎 235


//Given the root of a binary tree, return the level order traversal of its 
//nodes' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 12041 👎 235


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q102BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {

            Deque<TreeNode> dq = new ArrayDeque<>();
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;

            List<Integer> cur = new LinkedList<>();

            int count = 1;
            dq.addLast(root);

            while (!dq.isEmpty()) {
                count = dq.size();
                while (count > 0) {
                    cur.add(dq.peek().val);
                    if (dq.peek().left != null) dq.addLast(dq.peek().left);
                    if (dq.peek().right != null) dq.addLast(dq.peek().right);
                    dq.poll();
                    count--;
                }

                res.add(cur);
                cur = new LinkedList<>();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}