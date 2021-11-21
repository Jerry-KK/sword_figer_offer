package chapter7_queue;

import java.util.*;

/**
 * @author lethe
 * @date 2021/11/21 16:44
 */

/**
 * 题目：给定一棵二叉树，如果站在该二叉树的右侧，那么从上到下看到的节点构成二叉树的右侧视图。
 */
public class Questions_46 {

    public List<Integer> findRightView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue2.offer(node.left);
                stack.push(node.left.val);
            }
            if(node.right != null) {
                queue2.offer(node.right);
                stack.push(node.right.val);
            }
            if(queue.isEmpty()) {
                queue = queue2;
                queue2 = new LinkedList<>();
                if(!queue.isEmpty()) {
                    res.add(stack.peek());
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new LinkedList<>();
        if(root == null) {
            return view;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null)
                queue2.offer(node.left);
            if(node.right != null)
                queue2.offer(node.right);
            if(queue.isEmpty()){
                view.add(node.val);
                queue = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return view;
    }
}
