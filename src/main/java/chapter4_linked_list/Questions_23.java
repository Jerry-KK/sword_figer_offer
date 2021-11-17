package chapter4_linked_list;

/**
 * @author koujn
 * @date 2021/11/17 11:50
 */

/**
 * 题目：输入两个单向链表，请问如何找出它们的第一个重合节点。
 */
public class Questions_23 {

    public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        int count1 = countList(headA);
        int count2 = countList(headB);
        if(count1 > count2)
            for (int i = 0; i < count1-count2; i++)
                headA = headA.next;
        if(count1 < count2)
            for (int i = 0; i < count2-count1; i++)
                headB = headB.next;
        //这里不需要判空，都为null时相同会返回null
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }

    private int countList(ListNode head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

}
