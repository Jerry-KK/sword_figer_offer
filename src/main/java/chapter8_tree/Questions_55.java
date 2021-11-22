package chapter8_tree;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/22 17:50
 */

/**
 *题目：请实现二叉搜索树的迭代器BSTIterator，它主要有如下3个函数
 * 1.构造函数:输入二叉搜索树的根节点初始化该迭代器
 * 2.函数next:返回二叉搜索树中下一个最小的节点的值
 * 3.函数hasNext:返回二叉搜索树是否还有下一个节点
 */
public class Questions_55 {

    public class BSTIterator {
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            cur = root;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }
    }

}
