package chapter7_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author koujn
 * @date 2021/11/19 17:40
 */

/**
 * 题目:如何在一棵二叉树中找出它最底层最左边节点的值?
 * 假设二叉树中最少有一个节点。
 */
public class Questions_45 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        int res = root.val;
        queue1.offer(root);
        while (queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if(node.left != null)
                queue2.offer(node.left);
            if(node.right != null)
                queue2.offer(node.right);
            if(queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList();
                if(!queue1.isEmpty())
                    res = queue1.peek().val;
            }
        }
        return res;
    }

}
