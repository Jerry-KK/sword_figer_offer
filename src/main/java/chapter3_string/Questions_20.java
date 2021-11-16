package chapter3_string;

/**
 * @author lethe
 * @date 2021/11/16 23:57
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
