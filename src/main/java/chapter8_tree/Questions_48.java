package chapter8_tree;

import java.util.Stack;

/**
 * @author lethe
 * @date 2021/11/21 21:52
 */

/**
 * 请设计一个算法将二叉树序列化成一个字符串，并能将该字符串反序列化出原来二叉树的算法
 */
public class Questions_48 {

    public String serialize(TreeNode root) {
        if(root == null)
            return "#";
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return root.val + "," + leftStr + "," + rightStr;
    }

    public TreeNode test(String str) {
        if("#".equals(str))
            return null;
        String[] arr = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        int i = 1;
        while (node != null && !stack.isEmpty()) {
            while (!arr[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(arr[i++]));
                stack.push(node);
                node = node.left;
            }
            i += 2;
            if(!arr[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(arr[i++]));
                node = node.right;
                stack.push(node);
            }else {
                ++i;
                stack.pop();
                node = stack.peek();
            }
        }
        return root;
    }

    public TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = {0};
        return dfs(nodeStrs,i);
    }

    private TreeNode dfs(String[] strs,int[] i) {
        String str = strs[i[0]];
        i[0]++;
        if(str.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfs(strs,i);
        node.right = dfs(strs,i);
        return node;
    }


}
