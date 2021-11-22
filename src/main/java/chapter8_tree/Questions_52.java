package chapter8_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/22 16:47
 */

/**
 * 题目：给定一颗二叉搜索树，请调整节点的指针使每个节点都没有左子节点。调整之后的树看起来像一个链表，但仍然使二叉搜索树。
 * 思路：中序遍历
 */
public class Questions_52 {

    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        dfs(root,list);
        list.add(null);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
        return list.get(0);
    }

    private void dfs(TreeNode node,List<TreeNode> list) {
        if(node != null) {
            dfs(node.left,list);
            list.add(node);
            dfs(node.right,list);
        }
    }

    //迭代写法
    public TreeNode increasingBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(prev != null) {
                prev.right = cur;
            }else {
                first = cur;
            }
            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }
}
