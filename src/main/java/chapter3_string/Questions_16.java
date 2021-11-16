package chapter3_string;

/**
 * @author koujn
 * @date 2021/11/16 17:34
 */

import java.util.Map;

/**
 * 题目：输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。
 * 例如，输入字符串"babcca"，其最长的不含重复字符的子字符串是"abc",长度为3。
 */
public class Questions_16 {

    public static void main(String[] args) {
        Questions_16 body = new Questions_16();
        int max = body.getMax("aac");
        System.out.println(max);
    }

    public int getMax(String str) {
        if(str.length() < 2)
            return str.length();
        int max = 1;
        int i = 0;
        int j = 0;
        int[] arr = new int[26];
        while (j < str.length()) {
            if(arr[str.charAt(j) -'a'] == 1) {
                max = Math.max(max,j-i-1);
                while (str.charAt(i) != str.charAt(j))
                    arr[str.charAt(i++)-'a'] = 0;
                ++i;
                ++j;
            }else {
                arr[str.charAt(j++) -'a'] = 1;
            }
        }
        max = Math.max(max,j-i-1);
        return max;
    }
}
