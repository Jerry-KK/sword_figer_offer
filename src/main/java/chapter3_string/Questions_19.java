package chapter3_string;

/**
 * @author lethe
 * @date 2021/11/16 23:35
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
