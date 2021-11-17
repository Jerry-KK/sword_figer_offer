package chapter4_linked_list;

/**
 * @author koujn
 * @date 2021/11/17 10:40
 */

/**
 * 题目：如果一个链表中包含环，那么应该如何找出环的入口节点？从链表的头节点开始顺着next指针方向进入环的第1个节点为环的入口节点。
 */
public class Questions_22 {

    //第一步是如何确定一个链表中包含环。如果一个链表中没有环，那么自然不存在环的入口节点，此时应该返回null。通过快慢指针判断，步长为1和2
    public ListNode getNodeInLoop(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1 = dummy;
        ListNode n2 = dummy;
        while (n2.next != null && n2.next.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
            if(n1 == n2)
                return n1;
        }
        return null;
    }

    //第二步是如何找到环的入口节点，可以用两个指针来解决。先计算环的长度，然后快慢指针找入口
    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if(inLoop == null)
            return null;
        int loopCount = 1;
        for (ListNode n = inLoop.next;n != inLoop;n = n.next)
            ++loopCount;
        ListNode fast = head;
        for (int i = 0; i < loopCount; i++)
            fast = fast.next;
        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 优化：不需要知道环中节点数目的解法
     * 上面方法需要求出链表的环中节点的数目。如果仔细分析，就会发现其实并没有必要求得环中节点得数目。如果链表中有环，快慢两个指针一定会在环中的某个
     * 节点相遇。慢的指针一次走一步，假设在相遇时慢的指针一共走了k步。由于快的指针一次走两步，因此在相遇时快的指针一共走了2k步。因此，到相遇时快的
     * 指针比慢的指针多走了k步。另外，两个指针相遇时快的指针比慢的指针在环中多转了若干圈。也就是说，两个指针相遇时快的指针多走的步数k一定是环中节点
     * 的数目的整倍数，此时慢的指针走过的步数k也是环中节点数的整倍数。
     * 此时可以让一个指针指向相遇的节点，该指针的位置是之前慢的指针走了k步到达的位置。接着让另一个指针指向链表的头节点，然后两个指针以相同的速度一起
     * 朝着指向下一个节点的指针移动，当前面的指针到达环的入口节点时，钱买你的指针比它夺走了k步，而k是环中节点的数目的整倍数，相当于前面的指针在环中
     * 转了k圈后也到达环的入口节点，两个指针正好相遇。也就是说，两个指针相遇的节点正好是换的入口节点。
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if(inLoop == null)
            return null;
        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }
}
