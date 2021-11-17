package chapter4_linked_list;

/**
 * @author koujn
 * @date 2021/11/17 10:25
 */

/**
 * 题目：如果给定一个链表，请问如何删除链表中的倒数第k个节点?假设链表中节点的总数为n，那么1<=k<=n。要求只能遍历链表一次
 */
public class Questions_21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode back = dummy, front = head;
        for (int i = 0; i < n; i++)
            back = back.next;
        while (back.next != null) {
            back = back.next;
            front = front.next;
        }
        front.next = front.next.next;
        return dummy.next;
    }
}
