package chapter4_linked_list;

/**
 * @author koujn
 * @date 2021/11/17 9:59
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = next.val;
    }

    public ListNode append(ListNode head, int value) {
        ListNode newNode = new ListNode(val);
        if(head == null)
            return newNode;
        ListNode node = head;
        while (node.next != null)
            node = node.next;
        node.next = newNode;
        return head;
    }

    //使用哨兵
    public ListNode append2(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        ListNode newNode = new ListNode(value);
        ListNode node = dummy;
        while (node.next != null)
            node = node.next;
        node.next = newNode;
        return dummy.next;
    }

    public ListNode delete(ListNode head, int value) {
        if(head == null)
            return head;
        if(head.val == value)
            return head.next;
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

    //使用哨兵
    public ListNode delete2(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null) {
            if(node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dummy.next;
    }
}
