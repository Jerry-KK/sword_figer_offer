package chapter10_trie;

import java.util.List;

/**
 * @author lethe
 * @date 2021/11/25 20:52
 */

/**
 * 题目：英语中有一个概念叫词根。在词根后面加上若干字符就能拼出更长的单词。例如，"an"是一个词根，在它后面加上"other"就能得到另一个单词"another".
 * 现在给定一个由词根组成的字典和一个英语句子，如果句子中的单词在字典中有它的词根，则用它的词根替换该单词；如果单词没有词根，则保留该单词。请输出替换
 * 后的句子。
 * 例如。如果词根字典包含字符串["cat","bat","rat"],英语句子为["the cattle was rattle by the battery"],
 * 则替换之后的句子是”the cat was rat by the bat“
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
