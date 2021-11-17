package chapter4_linked_list;

/**
 * @author lethe
 * @date 2021/11/17 20:43
 */

/**
 * 题目：给定两个表示非负整数的单向链表，请问如何实现这两个整数的相加并且把它们的和仍然用单向链表表示?链表中的每个节点表示整数十进制的一位，
 * 并且头节点对应整数的最高位数而尾节点对应整数的个位。
 * 例如，两个链表分别表示整数123和531，它们的和为654
 */
public class Questions_25 {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode listNode = addReversed(head1, head2);
        return reverseList(listNode);
    }

    private ListNode addReversed(ListNode head1,ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.val) +
                      (head2 == null ? 0 : head2.val) +
                      carry;
            carry = sum >= 10 ? 1: 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode newNode = new ListNode(sum);

            sumNode.next = newNode;
            sumNode = newNode;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        if(carry == 1) {
            sumNode.next = new ListNode(1);
        }
        return dummy.next;
    }



    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
