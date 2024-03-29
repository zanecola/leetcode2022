package questions.leetcode.editor.en;

//Given the root of a binary search tree, and an integer k, return the kᵗʰ 
//smallest value (1-indexed) of all the values of the nodes in the tree. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
// 
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
// Follow up: If the BST is modified often (i.e., we can do insert and delete 
//operations) and you need to find the kth smallest frequently, how would you 
//optimize? 
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 9132
// 👎 163


//Given the root of a binary search tree, and an integer k, return the kᵗʰ 
//smallest value (1-indexed) of all the values of the nodes in the tree. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
// 
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
// Follow up: If the BST is modified often (i.e., we can do insert and delete 
//operations) and you need to find the kth smallest frequently, how would you 
//optimize? 
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 9132
// 👎 163


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new Q230KthSmallestElementInABst().new Solution();
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
        public int kthSmallest(TreeNode root, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            Deque<TreeNode> s = new ArrayDeque<>();

            s.offer(root);

            while (!s.isEmpty()) {
                TreeNode cur = s.poll();
                pq.offer(cur.val);
                if (pq.size() > k) pq.poll();

                if (cur.left != null) s.offer(cur.left);
                if (cur.right != null) s.offer(cur.right);
            }

            return pq.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}