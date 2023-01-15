package questions.leetcode.editor.en;

//Given the root of a binary tree, return the preorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 6321 👎 170


//Given the root of a binary tree, return the preorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 6321 👎 170


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q144BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            Deque<TreeNode> s = new ArrayDeque<>();
            List<Integer> res = new LinkedList<>();

            TreeNode cur = root;

            while (cur != null || !s.isEmpty()) {
                while (cur != null) {
                    s.push(cur);
                    res.add(cur.val);
                    cur = cur.left;
                }

                if (!s.isEmpty()) {
                    cur = s.pop();
                    cur = cur.right;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}