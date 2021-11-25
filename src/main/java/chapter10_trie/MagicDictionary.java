package chapter10_trie;

/**
 * @author lethe
 * @date 2021/11/25 21:07
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
