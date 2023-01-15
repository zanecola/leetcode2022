package questions.leetcode.editor.en;

//Given the root of a binary tree, determine if it is a valid binary search 
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 1358
//1 👎 1109


//Given the root of a binary tree, determine if it is a valid binary search 
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 1358
//1 👎 1109


public class Q98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q98ValidateBinarySearchTree().new Solution();
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
        boolean res = true;

        public boolean isValidBST(TreeNode root) {
            getInfo(root);
            return res;
        }

        int[] getInfo(TreeNode node){
            int [] info = new int[]{node.val, node.val};
            if (node.left == null && node.right == null) return info;


            if (node.left != null){
                int [] left = getInfo(node.left);
                if (left[1] >= node.val) res = false;
                info[0] = left[0];
            }

            if (node.right != null){
                int [] right = getInfo(node.right);
                if (right[0] <= node.val) res = false;
                info[1] = right[1];
            }

            return info;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}