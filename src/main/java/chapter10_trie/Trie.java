package chapter10_trie;

import java.util.List;

/**
 * @author lethe
 * @date 2021/11/25 20:33
 */
public class Trie {

    static class TrieNode {
        public TrieNode[] children;
        public boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch:word.toCharArray()) {
            if(node.children[ch-'a'] == null)
                node.children[ch-'a'] = new TrieNode();
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch:word.toCharArray()) {
            if(node.children[ch-'a'] == null)
                return false;
            node = node.children[ch-'a'];
        }
        return node.isWord;
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (char ch:prefix.toCharArray()) {
            if(node.children[ch-'a'] == null)
                return false;
            node = node.children[ch-'a'];
        }
        return true;
    }



}
