package questions.leetcode.editor.en;

//Given the head of a linked list, return the list after sorting it in 
//ascending order. 
//
// 
// Example 1: 
// 
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
// 
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// Related Topics Linked List Two Pointers Divide and Conquer Sorting Merge 
//Sort 👍 9036 👎 276


//Given the head of a linked list, return the list after sorting it in 
//ascending order. 
//
// 
// Example 1: 
// 
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
// 
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// Related Topics Linked List Two Pointers Divide and Conquer Sorting Merge 
//Sort 👍 9036 👎 276


public class Q148SortList {
    public static void main(String[] args) {
        Solution solution = new Q148SortList().new Solution();
        ListNode n_1 = new ListNode(-1);
        ListNode n0 = new ListNode(0);
        ListNode n5 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n_1.next = n5;
        n5.next = n3;
        n3.next = n4;
        n4.next = n0;

        var res = solution.sortList(ListNode.getListNode(4, 2, 1, 3));

        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode();
            ListNode cur = dummy;

            ListNode mid = getMid(head);

            ListNode l1 = mid.next;
            mid.next = null;
            ListNode l2 = head;

            l1 = sortList(l1);
            l2 = sortList(l2);

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }

            if (l1 == null) cur.next = l2;
            if (l2 == null) cur.next = l1;

            return dummy.next;
        }

        ListNode getMid(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}