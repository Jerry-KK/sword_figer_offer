package chapter10_trie;

import java.util.List;

/**
 * @author lethe
 * @date 2021/11/25 20:33
 */

/**
 * 题目：请设计实现一棵前缀树Trie，它有如下操作。
 * 1.函数insert,在前缀树中添加一个字符串，
 * 2.函数search,查找字符串。如果前缀树中包含该字符串，则返回true，否则返回false.
 * 3.函数startWith,查找字符串前缀。如果前缀树中包含以该前缀开头的字符串，则返回true，否则返回false。
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
