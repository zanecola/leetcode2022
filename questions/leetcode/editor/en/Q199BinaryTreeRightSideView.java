package questions.leetcode.editor.en;

//Given the root of a binary tree, imagine yourself standing on the right side 
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
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
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 93
//01 👎 557


//Given the root of a binary tree, imagine yourself standing on the right side 
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
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
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 93
//01 👎 557


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new Q199BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();

            if (root == null) return res;

            Deque<TreeNode> stack1 = new ArrayDeque<>();
            Deque<TreeNode> stack2 = new ArrayDeque<>();

            stack1.offer(root);
            boolean use1 = true;
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                if (use1){
                    TreeNode cur = stack1.poll();
                    if (cur.left != null) stack2.offer(cur.left);
                    if (cur.right != null) stack2.offer(cur.right);

                    if (stack1.isEmpty()){
                        use1 = false;
                        res.offer(cur.val);
                    }
                } else {
                    TreeNode cur = stack2.poll();
                    if (cur.left != null) stack1.offer(cur.left);
                    if (cur.right != null) stack1.offer(cur.right);

                    if (stack2.isEmpty()){
                        use1 = true;
                        res.offer(cur.val);
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}