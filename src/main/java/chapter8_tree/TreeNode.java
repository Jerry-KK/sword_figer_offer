package chapter8_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lethe
 * @date 2021/11/21 17:10
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    //中序遍历，递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs(root,nodes);
        return nodes;
    }
    //dfs是Depth First Search的缩写，即深度优先搜索
    private void dfs(TreeNode node,List<Integer> nodes) {
        if(node != null) {
            dfs(node.left,nodes);
            nodes.add(node.val);
            dfs(node.right,nodes);
        }
    }

    //使用栈遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            if(stack.peek().left != null) {
                stack.push(stack.peek().left);
            }else {
                TreeNode node = stack.pop();
                nodes.add(node.val);
                if(node.right != null)
                    stack.push(node.right);
            }
        }
        return nodes;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nodes.add(cur.val);
            cur = cur.right;
        }
        return nodes;
    }

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        preorderDfs(root,nodes);
        return nodes;
    }

    private void preorderDfs(TreeNode node,List<Integer> nodes) {
        if(node != null) {
            nodes.add(node.val);
            preorderDfs(node.left,nodes);
            preorderDfs(node.right,nodes);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            result.add(cur.val);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
            cur = stack.pop();
        }
        return result;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        postorderDfs(root,nodes);
        return nodes;
    }

    private void postorderDfs(TreeNode node,List<Integer> nodes) {
        if(node != null) {
            postorderDfs(node.left,nodes);
            postorderDfs(node.right,nodes);
            nodes.add(node.val);
        }
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                stack.pop();
                nodes.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return nodes;
    }
}
