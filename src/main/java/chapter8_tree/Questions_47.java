package chapter8_tree;

/**
 * @author lethe
 * @date 2021/11/21 19:59
 */

/**
 * 一棵二叉树的所有节点的值要么是0要么是1，请剪除该二叉树中所有节点的值全都是0的子树。
 */
public class Questions_47 {

    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0)
            return null;
        return root;
    }


}
