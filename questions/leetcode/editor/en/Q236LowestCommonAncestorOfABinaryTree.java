package questions.leetcode.editor.en;

//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p 
//and q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], p = 1, q = 2
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q will exist in the tree. 
// 
//
// Related Topics Tree Depth-First Search Binary Tree 👍 13342 👎 322


//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p 
//and q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], p = 1, q = 2
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q will exist in the tree. 
// 
//
// Related Topics Tree Depth-First Search Binary Tree 👍 13342 👎 322


import java.util.Arrays;

public class Q236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q236LowestCommonAncestorOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode result = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            help(root, p, q);
            return result;
        }

        boolean[] help(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || result != null) return new boolean[2];
            boolean[] res = new boolean[]{false, false};

            boolean[] left = help(root.left, p, q);
            boolean[] right = help(root.right, p, q);

            res[0] = root.val == p.val || right[0] || left[0];
            res[1] = root.val == q.val || right[1] || left[1];

            if (res[0] && res[1] && result == null) result = root;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}