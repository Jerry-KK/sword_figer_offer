package chapter3_string;

/**
 * @author koujn
 * @date 2021/11/16 16:47
 */

/**
 * 题目：输入字符串s1和s2，如何判断字符串s2中是否包含字符串s1的某个变位词？如果字符串s2中包含字符串s1的某个变位词，
 * 则字符串s1至少有一个变位词是字符串s2的子字符串。
 * 假设两个字符串只包含英文小写字母。
 * 例如，字符串s1为"ac"，字符串s2为“dgcaf”，由于字符串s2中包含字符串s1的变位词"ca",因此输出为true。
 * 如果字符串s1为“ab”.字符串s2为"dgcaf"，则输出为false。
 */
public class Questions_14 {

    public static void main(String[] args) {
        Questions_14 body = new Questions_14();
        System.out.println(body.checkInclusion("ac", "dgcaf"));
        System.out.println(body.checkInclusion("ab", "dgcaf"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            ++a[s1.charAt(i)-'a'];
            --a[s2.charAt(i)-'a'];
        }
        int i = 0;
        int j = s1.length();
        if(areAllZero(a))
            return true;
        while (j < s2.length()){
            ++a[s2.charAt(i++)-'a'];
            --a[s2.charAt(j++)-'a'];
            if(areAllZero(a))
                return true;
        }
        return false;
    }

    private boolean areAllZero(int[] arr) {
        for (int i:arr)
            if(i != 0)
                return false;
        return true;
    }
}
