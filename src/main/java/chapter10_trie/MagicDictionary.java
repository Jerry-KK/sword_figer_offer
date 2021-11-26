package chapter10_trie;

/**
 * @author lethe
 * @date 2021/11/25 21:07
 */

/**
 * 题目：请实现有如下两个操作的神奇字典。
 * 1.函数buildDict，输入单词数组用来创建一个字典。
 * 2.函数search.输入一个单词，判断能够修改该单词中的一个字符，使修改之后的单词是字典中的一个单词。
 */
public class MagicDictionary {

    static class TrieNode {
        public TrieNode[] children;
        public boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dict) {
        for (String word:dict) {
            TrieNode node = root;
            for (char ch:word.toCharArray()) {
                if(node.children[ch-'a'] == null)
                    node.children[ch-'a'] = new TrieNode();
                node = node.children[ch-'a'];
            }
            node.isWord = true;
        }
    }

    private boolean search(String word) {
        return dfs(root,word,0,0);
    }

    private boolean dfs(TrieNode root, String word, int i, int edit) {
        if(root == null)
            return false;
        if(root.isWord && word.length() == i && edit == 1)
            return true;
        if(i < word.length() && edit <= i) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i)-'a' ? edit : edit+1;
                found = dfs(root,word,i+1,next);
            }
            return found;
        }
        return false;
    }

}
