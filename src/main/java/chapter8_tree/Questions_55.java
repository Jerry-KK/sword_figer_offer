package chapter8_tree;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/22 17:50
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
            return cur != null && !stack.isEmpty();
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
