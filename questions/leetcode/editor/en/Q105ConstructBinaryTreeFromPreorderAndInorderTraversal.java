package questions.leetcode.editor.en;

//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 11882 
//👎 344


//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 11882 
//👎 344


import java.util.Arrays;

public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3, 9, 2, 1, 7}, new int[]{9, 3, 1, 2, 7});
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;

            return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        TreeNode helper(int[] pre, int[] in, int pl, int pr, int il, int ir) {
            // in:  9, 3,15,20,7
            //      il r      ir
            // pre: 3, 9,20,15,7
            //      pl        pr
            if (pl > pr || il > ir) return null;

            int rootIndex = 0;
            int rootV = pre[pl];

            for (int i = il; i <= ir; i++) {
                if (in[i] == rootV) {
                    rootIndex = i;
                    TreeNode res = new TreeNode(rootV);

                    res.left = helper(pre, in, pl + 1, pl + rootIndex - il, il, rootIndex-1);
                    res.right = helper(pre, in, pl + 1 + rootIndex - il, pr, rootIndex + 1, ir);

                    return res;
                }
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}