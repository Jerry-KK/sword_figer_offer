package chapter12_sort;

import chapter4_linked_list.ListNode;

/**
 * @author lethe
 * @date 2021/11/30 22:45
 */

/**
 * 题目：输入k个排序的链表，请将它们合并成一个排序的链表。
 */
public class Questions_78 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return mergeLists(lists,0,lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if(start + 1 == end) {
            return lists[start];
        }
        int mid = (start + end)/2;
        ListNode head1 = mergeLists(lists,start,mid);
        ListNode head2 = mergeLists(lists,mid,end);
        return merge(head1,head2);
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
