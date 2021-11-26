package chapter10_trie;

/**
 * @author koujn
 * @date 2021/11/26 11:03
 */

/**
 * 题目:输入一个整数数组（每个数字都大于或等于0），请计算其中任意两个数字的异或的最大值.
 * 例如，在数组[1,3,4,7]中，3和4的异或结果最大，异或结果为7.
 */
public class Questions_67 {

    static class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num:nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; --i) {
                int bit = (num>>i) & 1;
                if(node.children[bit] == null)
                    node.children[bit] = new TrieNode();
                node = node.children[bit];
            }
        }
        return root;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num:nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0 ; --i) {
                int bit = (num>>i) & 1;
                if(node.children[1-bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1-bit];
                }else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max,xor);
        }
        return max;
    }

}
