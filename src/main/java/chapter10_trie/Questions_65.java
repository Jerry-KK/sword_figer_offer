package chapter10_trie;

/**
 * @author lethe
 * @date 2021/11/25 21:30
 */

/**
 * 题目：输入一个包含n个单词的数组，可以把它们编码成一个字符串和n个下标。例如，单词数组["time","me","bell"]可以编码成一个字符串”time#bell#“，
 * 然后这些单词就可以通过下标[0,2,5]得到，对于每个下标，都可以从编码得到得字符串中相应得位置开始扫描，直到遇到‘#’字符前所经过得子字符串为单词数组中
 * 的一个单词，
 * 例如，从”time#bell“下标为2的位置开始扫描，直到遇到'#'前经过字符串"me"是给定单词数组的第2个单词。给定一个单词数组，请问按照上述规则把这些单词
 * 编码之后得到的最短字符串的长度是多少？如果输入的是字符串数组["time","me","bell"],那么编码之后最短的字符串是"time#bell#",长度是10
 */
public class Questions_65 {

    static class TrieNode {
        public TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);
        int[] total = {0};
        dfs(root,1,total);
        return total[0];
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word:words) {
            TrieNode node = root;
            for (char ch:word.toCharArray()) {
                if(node.children[ch-'a'] == null)
                    node.children[ch-'a']=new TrieNode();
                node = node.children[ch-'a'];
            }
        }
        return root;
    }


    private void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child:root.children) {
            if(child != null) {
                isLeaf = false;
                dfs(root,length+1,total);
            }
        }
        if(isLeaf)
            total[0] += length;
    }
}
