package chapter4_linked_list;

/**
 * @author koujn
 * @date 2021/11/17 17:01
 */

import java.util.Stack;

/**
 * 题目：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后的链表的头节点。
 */
public class Questions_24 {

    private ListNode last = null;

    public ListNode reversalLinkedList(ListNode node) {
        reversal(node);
        return last;
    }

    private ListNode reversal(ListNode node) {
        if(node.next != null) {
            ListNode reversal = reversalLinkedList(node.next);
            reversal.next = node;
        }else {
            last = node;
        }
        return node;
    }

    public ListNode reversalLinkedList2(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node!= null) {
            stack.push(node);
            node = node.next;
        }
        ListNode newHead = stack.pop();
        ListNode n = newHead;
        while (!stack.isEmpty()){
            n.next = stack.pop();
            n = n.next;
        }
        return newHead;
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
