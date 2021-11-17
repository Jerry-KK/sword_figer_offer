package chapter4_linked_list;

/**
 * @author lethe
 * @date 2021/11/17 23:28
 */


/**
 * 问题:在一个循环链表中节点的值递增排序，请设计一个算法在该循环链表中插入节点，并保证插入节点之后的循环链表仍然是排序的。
 * 这里ListNode是循环链表
 */
public class Questions_29 {

    public ListNode insert(ListNode head, int insertVal) {
        ListNode node = new ListNode(insertVal);
        if(head == null) {
            head = node;
        }else if(head.next == head) {
            head.next = node;
            node.next = head;
        }else {
            insertCore(head,node);
        }
        return head;
    }

    private void insertCore(ListNode head, ListNode node) {
        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode biggerNode = head;
        while (!(node.val >= n1.val && node.val <= n2.val) && n2 != head) {
            n1 = n2;
            n2 = n2.next;
            if(n1.val > biggerNode.val)
                biggerNode = n1;
        }
        if(node.val >= n1.val && node.val <= n2.val) {
            n1.next = node;
            node.next = n2;
        }else {
            node.next = biggerNode.next;
            biggerNode.next = node;
        }
    }
}
