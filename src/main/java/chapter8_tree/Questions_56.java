package chapter8_tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/**
 * @author lethe
 * @date 2021/11/22 21:17
 */

/**
 * 题目:给定一棵二叉搜索树和一个值k,请判断该二叉搜索树中是否存在值之和等于k的两个节点.
 */
public class Questions_56 {

    //利用hash表，适用所有二叉树，没有体现二叉搜索树
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(set.contains(k-node.val))
                return true;
            set.add(node.val);
            node = node.right;
        }
        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
        Questions_55.BSTIterator bstIterator = new Questions_55().new BSTIterator(root);
        BSTIteratorReversed bstIteratorReversed = new BSTIteratorReversed(root);
        int low = bstIterator.next();
        int high = bstIteratorReversed.prev();
        while (low < high) {
            if(low + high > k)
                high = bstIteratorReversed.prev();
            else if(low + high < k)
                low = bstIterator.next();
            else
                return true;
        }
        return false;
    }

    public class BSTIteratorReversed {
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIteratorReversed(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public boolean havePrev() {
            return cur != null || !stack.isEmpty();
        }

        public int prev() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.left;
            return val;
        }


    }

}
