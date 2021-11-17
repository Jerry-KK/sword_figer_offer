package chapter4_linked_list;

/**
 * @author lethe
 * @date 2021/11/17 21:25
 */

/**
 * 问题：如何判断一个链表是不是回文?要求解法的时间复杂度是O(n),并且不得使用超过O(1)的辅助空间。如果一个链表是回文，那么链表的节点序列从前往后
 * 看和从后往前是相同的。
 */
public class Questions_27 {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while ( fast != null ){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode last = reverseList(temp);
        while (last != null) {
            if(head != last){
                return false;
            }
            last = last.next;
            head = head.next;
        }
        return true;
    }

    private  ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
