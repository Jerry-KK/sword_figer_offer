package chapter3_string;

/**
 * @author lethe
 * @date 2021/11/16 23:57
 */

/**
 * 题目：给定一个字符串，请问该字符串中有多少个回文连续子字符串？
 * 例如，字符串"abc"有3个回文子字符串，分别为"a","b"和"c"；而字符串"aaa"有6个回文子字符串，分别是"a"、"a"、"a"、"aa"、"aa"、"aaa"
 */
public class Questions_20 {

    public static void main(String[] args) {
        Questions_20 body = new Questions_20();
        int n = body.countSubstrings("abcba");
        System.out.println(n);
    }

    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < s.length() ; i++) {
            count+=countPalindrome(s,i,i);
            count+=countPalindrome(s,i,i+1);
        }
        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            ++count;
            --start;
            ++end;
        }
        return count;
    }

}
