package chapter7_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author koujn
 * @date 2021/11/19 11:03
 */


public class Questions_43 {

    /**
     * 二叉树的广度优先搜索
     */
    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if(poll.left != null)
                queue.add(poll.left);
            if(poll.right != null)
                queue.add(poll.right);
        }
        return list;
    }

    /**
     * 面试题：在完全二叉树中，除最后一层之外其他层的节点都是满的(第n层有2^(n-1)个节点)。最后一层的节点可能不满，该层所有的节点尽可能向
     * 左边靠拢。
     * 实现数据结构CBTInserter有如下3中方法。
     * 1.构造函数CBTInserter(TreeNode root),用一颗完全二叉树的根节点初始化该数据结构。
     * 2.函数insert(int val)在完全二叉树中添加一个值为v的节点，并返回被插入节点的父节点。
     * 3.函数get_root()返回完全二叉树的根节点。
     */
    class CBTInserter {

        private Queue<TreeNode> queue;
        private TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;

            queue = new LinkedList<>();
            queue.offer(root);
            while (queue.peek().left != null && queue.peek().right != null) {
                TreeNode node = queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode parent = queue.peek();
            TreeNode node = new TreeNode();
            node.val = v;
            if(parent.left == null){
                parent.left = node;
            }else {
                parent.right = node;
                queue.offer(parent.left);
                queue.offer(parent.right);
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return this.root;
        }

    }
}
