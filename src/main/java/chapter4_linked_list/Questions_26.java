package chapter4_linked_list;

/**
 * @author lethe
 * @date 2021/11/17 21:09
 */

/**
 * 问题：给定一个链表，链表中节点的顺序是l0->l1->l2->...->l(n-1)->l(n)
 * 请问如何重排链表使节点的顺序变成l0->l(n)->l2->l(n-1)->...?
 */
public class Questions_26 {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            //如果长度为奇数，最后一步slow和fast都只走了1步，slow在中心点
            if(fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        slow.next = null;
        link(head,reverseList(temp),dummy);
    }

    private void link(ListNode node1, ListNode node2, ListNode head) {
        ListNode prev = head;
        while (node1 != null && node2 != null) {
            ListNode temp = node1.next;
            prev.next = node1;
            node1.next = node2;
            prev = node2;
            node1 = temp;
            node2 = node2.next;
        }
        if(node1 != null) {
            prev.next = node1;
        }

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
