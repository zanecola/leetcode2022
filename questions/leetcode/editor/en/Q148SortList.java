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

            int pivot = getMid(head).val;

            ListNode large = new ListNode();
            ListNode largeCur = large;
            ListNode small = new ListNode();
            ListNode smallCur = small;
            ListNode eq = new ListNode();
            ListNode eqCur = eq;

            ListNode cur = head;
            while (cur != null) {
                var next = cur.next;
                if (cur.val > pivot) {
                    largeCur.next = cur;
                    cur.next = null;
                    largeCur = largeCur.next;
                } else if (cur.val < pivot) {
                    smallCur.next = cur;
                    cur.next = null;
                    smallCur = smallCur.next;
                } else {
                    eqCur.next = cur;
                    cur.next = null;
                    eqCur = eqCur.next;
                }
                cur = next;
            }


            large = sortList(large.next);
            small = sortList(small.next);

            eqCur.next = large;

            if (small == null) {
                return eq.next;
            } else {
                smallCur = small;
                while (smallCur.next != null) {
                    smallCur = smallCur.next;
                }

                smallCur.next = eq.next;
                return small;
            }
        }

        public ListNode getMid(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}