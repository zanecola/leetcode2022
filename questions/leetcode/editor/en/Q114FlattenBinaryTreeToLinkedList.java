package questions.leetcode.editor.en;

//Given the root of a binary tree, flatten the tree into a "linked list": 
//
// 
// The "linked list" should use the same TreeNode class where the right child 
//pointer points to the next node in the list and the left child pointer is always 
//null. 
// The "linked list" should be in the same order as a pre-order traversal of 
//the binary tree. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
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
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Can you flatten the tree in-place (with 
//O(1) extra space)?
//
// Related Topics Linked List Stack Tree Depth-First Search Binary Tree 👍 9864 
//👎 498


//Given the root of a binary tree, flatten the tree into a "linked list": 
//
// 
// The "linked list" should use the same TreeNode class where the right child 
//pointer points to the next node in the list and the left child pointer is always 
//null. 
// The "linked list" should be in the same order as a pre-order traversal of 
//the binary tree. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
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
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Can you flatten the tree in-place (with 
//O(1) extra space)?
//
// Related Topics Linked List Stack Tree Depth-First Search Binary Tree 👍 9864 
//👎 498


import java.util.ArrayDeque;
import java.util.Deque;

public class Q114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q114FlattenBinaryTreeToLinkedList().new Solution();
        var t1 = new TreeNode(1);
        var t2 = new TreeNode(2);
        var t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        solution.flatten(t1);
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
        public void flatten(TreeNode root) {
            Deque<TreeNode> s = new ArrayDeque<>();

            TreeNode pre = null;
            if (root == null) return;
            s.push(root);

            while (!s.isEmpty()) {
                var cur = s.pop();
                if (pre != null) {
                    pre.right = cur;
                    pre.left = null;
                }

                if (cur.right != null) s.push(cur.right);
                if (cur.left != null) s.push(cur.left);

                pre = cur;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}