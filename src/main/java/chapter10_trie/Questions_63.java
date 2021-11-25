package chapter10_trie;

import java.util.List;

/**
 * @author lethe
 * @date 2021/11/25 20:52
 */
public class Questions_63 {

    private Trie.TrieNode buildTrie(List<String> dict) {
        Trie.TrieNode root = new Trie.TrieNode();
        for (String word:dict) {
            Trie.TrieNode node = root;
            for (char ch:word.toCharArray()) {
                if(node.children[ch-'a'] == null)
                    node.children[ch-'a'] = new Trie.TrieNode();
                node = node.children[ch-'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    private String findPrefix(Trie.TrieNode root,String word) {
        Trie.TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char ch:word.toCharArray()) {
            if(node.isWord || node.children[ch-'a']==null)
                break;
            builder.append(ch);
            node = node.children[ch-'a'];
        }
        return node.isWord ? builder.toString() : "";
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie.TrieNode root = buildTrie(dict);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if(!prefix.isEmpty())
                words[i] = prefix;
        }
        return String.join(" ",words);
    }

}
