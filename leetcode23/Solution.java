package leetcode23;


import java.util.Map;

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
        // 如果有空的列表，返回那个非空的列表
        // 两个链表都是空的话，返回null
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        // 初始化工作指针
        ListNode workPtr = null;
        ListNode head = null;
        if (a.val < b.val) {
            workPtr = a;
            head = a;
            a = a.next;

        } else {
            workPtr = b;
            head = b;
            b = b.next;
        }

        // 工作指针不断移动
        while (a!=null && b!=null) {
            if (a.val < b.val) {
                workPtr.next = a;
                a = a.next;
            } else {
                workPtr.next = b;
                b = b.next;
            }
            workPtr = workPtr.next;
        }

        // 某一个列表还有未拼接的元素
        if (a == null) {
            workPtr.next = b;
        } else {
            workPtr.next = a;
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
