package leetcode23;


/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/


class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Solution {

    ListNode merge2Lists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = a.val > b.val ? b : a;
        // a永远指向最小的节点
        while (a != null) {
            if (a.val > b.val) {
                ListNode temp;
                temp = a;
                a = b;
                b = temp;
            }
            // 如果a后面还有别的节点而且
            // 如果a后面的值一直相等的话，或者比b小那么指针往后移
            while (a.next!=null && (a.val == a.next.val || a.val <= b.val)) a = a.next;

            // 指针重置
            ListNode nextA = null;
            if (a.next != null) {
                nextA = a.next.next;
            }
            a.next = b;
            a = nextA;

            // 如果b后面还有别的节点而且
            // 如果b后面的值一直相等的话
            while (b.next!=null && b.val==b.next.val) b = b.next;
            
        }

        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = merge2Lists(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++) {
            head = merge2Lists(head, lists[i]);
        }

        return head;
    }
}
