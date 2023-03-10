package questions.leetcode.editor.en;

//Given the root of a binary tree, return the zigzag level order traversal of 
//its nodes' values. (i.e., from left to right, then right to left for the next 
//level and alternate between). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 8911 👎 237


//Given the root of a binary tree, return the zigzag level order traversal of 
//its nodes' values. (i.e., from left to right, then right to left for the next 
//level and alternate between). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 8911 👎 237


import java.util.*;

public class Q103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Deque<TreeNode> queue = new ArrayDeque<>();
            Deque<TreeNode> stack = new ArrayDeque<>();

            LinkedList<Integer> list = new LinkedList<>();

            int counter = 0;

            queue.push(root);

            while (!queue.isEmpty() || !stack.isEmpty()) {
                if (counter % 2 == 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) stack.offer(cur.left);
                    if (cur.right != null) stack.offer(cur.right);
                    list.offer(cur.val);

                    if (queue.isEmpty()) {
                        res.add(list);
                        list = new LinkedList<>();

                        counter++;
                    }
                } else {
                    TreeNode cur = stack.pop();
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    list.push(cur.val);

                    if (stack.isEmpty()) {
                        res.add(list);
                        list = new LinkedList<>();

                        counter++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}