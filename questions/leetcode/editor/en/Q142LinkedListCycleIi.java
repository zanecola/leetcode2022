package questions.leetcode.editor.en;

//Given the head of a linked list, return the node where the cycle begins. If 
//there is no cycle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to (0
//-indexed). It is -1 if there is no cycle. Note that pos is not passed as a 
//parameter. 
//
// Do not modify the linked list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the 
//second node.
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the 
//first node.
// 
//
// Example 3: 
// 
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
//
// Related Topics Hash Table Linked List Two Pointers 👍 9930 👎 724


//Given the head of a linked list, return the node where the cycle begins. If 
//there is no cycle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to (0
//-indexed). It is -1 if there is no cycle. Note that pos is not passed as a 
//parameter. 
//
// Do not modify the linked list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the 
//second node.
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the 
//first node.
// 
//
// Example 3: 
// 
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
//
// Related Topics Hash Table Linked List Two Pointers 👍 9930 👎 724


public class Q142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new Q142LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;

            ListNode pre = new ListNode();
            pre.next = head;

            ListNode p1 = pre;
            ListNode p2 = pre;

            int cnt = 0;

            while (p2.next != null && p2.next.next != null) {
                p2 = p2.next.next;
                p1 = p1.next;
                cnt++;

                if (p1 == p2) break;
            }

            if (p2.next == null || p2.next.next == null) return null;

            p1 = pre;
            p2 = pre;

            while (cnt-- > 0) {
                p2 = p2.next;
            }

            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}