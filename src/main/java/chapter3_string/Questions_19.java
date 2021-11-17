package chapter3_string;

/**
 * @author lethe
 * @date 2021/11/16 23:35
 */

/**
 * 题目：给定一个字符串，请判断如果最多从字符串中删除一个字符能不能得到一个回文字符串。
 * 例如，如果输入字符串"abcd"，由于删除字符'b'或'c'就能得到一个回文字符串，因此输出为true。
 */
public class Questions_19 {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        for(; start < s.length()/2;++start,--end) {
            if(s.charAt(start) != s.charAt(end))
                break;
        }
        return start == s.length()/2 ||
                isPalindrome(s,start,end-1) ||
                isPalindrome(s,start+1, end);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            ++start;
            --end;
        }
        return true;
    }

}
