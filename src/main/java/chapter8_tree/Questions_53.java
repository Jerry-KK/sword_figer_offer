package chapter8_tree;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/22 17:01
 */

/**
 * 题目：给定一颗二叉搜索树和它的一个节点p，请找出按中序遍历的顺序该节点p的下一个节点。
 * 假设二叉搜索树中节点的值都是唯一的。
 */
public class Questions_53 {

    //中序遍历
    public TreeNode inorderSuccessor(TreeNode root,TreeNode p) {
        if(root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        boolean flag = false;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(flag){
                break;
            }else if(node == p) {
                flag = true;
            }
            node = node.right;
        }
        return node;
    }

    public TreeNode findNext(TreeNode root,TreeNode p) {
        TreeNode node = root;
        while (node != null){
            if(node.val > p.val)
                node = node.left;
            else if(node.val < p.val)
                node = node.right;
            else
                break;
        }
        if(node != null && node.right != null) {
            TreeNode next = node.right;
            while (next.left != null)
                next = next.left;
            return next;
        }
        return null;
    }

    public TreeNode inorderSuccessor2(TreeNode root,TreeNode p) {
        TreeNode node = root;
        TreeNode result = null;
        while (node != null) {
            if(node.val > p.val) {
                result = node;
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return result;
    }
}
