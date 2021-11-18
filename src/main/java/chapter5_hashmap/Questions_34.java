package chapter5_hashmap;

/**
 * @author koujn
 * @date 2021/11/18 15:10
 */

/**
 * 题目：有一门外星语言,它的字母表刚好包含所有的英文小写字母,只是字母表的顺序不同。给定一组单词和字母表顺序，请判断这些单词是否按照字母表的顺序排序。
 * 例如，输入一组单词["offer","is","coming"]，以及字母表顺序"zyxwvutsrqponmlkjihgfedcba",由于字母'o'在字母表中位于’i‘的前面，因此单词
 * "offer"排在"is"的前面。
 */
public class Questions_34 {

    public boolean isAlienSorted(String[] words, String order) {
        if(words.length < 2)
            return true;
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++)
            arr[order.charAt(i)-'a'] = i;
        for (int i = 0; i < words.length-1; i++)
            if(!isSorted(words[i], words[i + 1], arr))
                return false;
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] order) {
        int l = Math.min(word1.length(),word2.length());
        for (int i = 0; i < l; i++) {
            if(order[word1.charAt(i)] > order[word2.charAt(i)])
                return true;
            else if(order[word1.charAt(i)] < order[word2.charAt(i)])
                return false;
        }
        return word1.length() == l;
    }
}
