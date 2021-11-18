package chapter5_hashmap;

/**
 * @author koujn
 * @date 2021/11/18 11:53
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给定两个字符串s和t,请判断它们是不是一组变位词。在一组变位词中，它们中的字符及每个字符出现的次数都相同，但字符的顺序不能相同。
 * 例如,"anagram"和"nagaram"就是一组变位词。
 */
public class Questions_32 {

    public static void main(String[] args) {

        /**
         * char型变量是用来存储Unicode编码的字符的，unicode编码字符集中包含了汉字，
         * 所以，char型变量中当然可以存储汉字啦。不过，如果某个特殊的汉字没有被包含在
         * unicode编码字符集中，那么，这个char型变量中就不能存储这个特殊汉字。补充
         * 说明：unicode编码占用两个字节，所以，char类型的变量也是占用两个字节。
         */
        char c = '我';
        System.out.println(c);
        String s = "这是一句中文Chinese!哈哈";
        for (char ch:s.toCharArray()) {
            System.out.println(ch);
        }
    }

    //只考虑小写字母
    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length() || s1.equals(s2))
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ++arr[s1.charAt(i)-'a'];
            --arr[s2.charAt(i)-'a'];
        }
        for (int a:arr)
            if(a != 0)
                return false;
        return true;
    }

    //只考虑小写字母
    public boolean isAnagram2(String s1, String s2) {
        if(s1.length() != s2.length() || s1.equals(s2))
            return false;
        int[] arr = new int[26];
        for (char ch:s1.toCharArray()) {
            ++arr[ch-'a'];
        }
        for (char ch:s2.toCharArray()) {
            if(arr[ch-'a'] == 0)
                return false;
            --arr[ch-'a'];
        }
        return true;
    }

    //考虑所有字符
    public boolean isAnagram3(String s1, String s2) {
        if(s1.length() != s2.length() || s1.equals(s2))
            return false;
        Map<Character,Integer> counts = new HashMap<>();
        for (char ch:s1.toCharArray()) {
            counts.put(ch,counts.getOrDefault(ch,0)+1);
        }
        for (char ch:s2.toCharArray()) {
            if(counts.get(ch) == null)
                return false;
            else if(counts.get(ch) == 1)
                counts.remove(ch);
            else
                counts.put(ch,counts.get(ch)-1);
        }
        return true;
    }
}
