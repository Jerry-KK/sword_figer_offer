package chapter12_sort;

import chapter4_linked_list.ListNode;

/**
 * @author lethe
 * @date 2021/11/30 22:58
 */

/**
 * 题目:输入一个链表的头节点，请将该链表排序。
 */
public class Questions_77 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = split(head);
        head1 = sortList(head1);
        head2 = sortList(head2);

        return merge(head1,head2);
    }

    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }

    private ListNode merge(ListNode head1,ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            }else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

}
