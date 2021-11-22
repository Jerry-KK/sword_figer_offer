package chapter8_tree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/22 17:33
 */

/**
 * 题目：给定一颗二叉搜索树，请将它的每个节点的值替换成树中大于或等于该节点值的所有节点值之和。
 * 假设二叉搜索树中节点的值唯一。
 */
public class Questions_54 {

    //中序遍历：值从小到大
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        dfs(root,list);
        int sum = 0;
        for (int i = list.size()-1; i >= 0 ; --i) {
            TreeNode node = list.get(i);
            sum+=node.val;
            node.val = sum;
        }
        return root;
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if(node != null) {
            dfs(node.left,list);
            list.add(node);
            dfs(node.right,list);
        }
    }

    //颠倒的中序遍历，有右边，再中间，再左边，值从大到小遍历
    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }

}
