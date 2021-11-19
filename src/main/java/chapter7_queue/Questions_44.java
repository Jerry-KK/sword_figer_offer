package chapter7_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author koujn
 * @date 2021/11/19 17:27
 */

/**
 * 题目：输入一颗二叉树，请找出二叉树中每层的最大值。
 */
public class Questions_44 {

    public List<Integer> largestValues(TreeNode root) {
        int current = 0;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
            current = 1;
        }
        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            max = Math.max(max, node.val);

            if(node.left != null) {
                queue.offer(node.left);
                ++next;
            }

            if(node.right != null) {
                queue.offer(node.right);
                ++next;
            }

            if(current == 0) {
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;
    }
}
