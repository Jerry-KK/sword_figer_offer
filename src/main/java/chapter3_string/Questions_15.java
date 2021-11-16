package chapter3_string;

/**
 * @author koujn
 * @date 2021/11/16 16:47
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：输入字符串s1和s2，如何找出字符串s1的所有变位词在字符串s2中的起始下标？
 * 假设两个字符串只包含英文小写字母。
 * 例如，字符串s1为"abc"，字符串s2为“cbadabacg”，由于字符串s2中包含字符串s1的变位词"ca",因此输出为true。
 * 如果字符串s1为“cba”.字符串s2为"bac"，则输出为false。
 */
public class Questions_15 {

    public static void main(String[] args) {
        Questions_15 body = new Questions_15();
        System.out.println(body.findAnagrams("abc", "cbadabacg"));
        System.out.println(body.findAnagrams("cba", "bac"));
    }

    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> list = new ArrayList<>();
        if(s1.length() > s2.length())
            return list;
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            ++a[s1.charAt(i)-'a'];
            --a[s2.charAt(i)-'a'];
        }
        if(areAllZero(a))
            list.add(0);
        int i = 0;
        int j = s1.length();
        while (j < s2.length()){
            ++a[s2.charAt(i++)-'a'];
            --a[s2.charAt(j++)-'a'];
            if(areAllZero(a))
                list.add(i);
        }
        return list;
    }

    private boolean areAllZero(int[] arr) {
        for (int i:arr)
            if(i != 0)
                return false;
        return true;
    }
}
