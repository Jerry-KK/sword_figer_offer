package chapter3_string;

/**
 * @author lethe
 * @date 2021/11/16 23:32
 */
public class Questions_18 {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(!Character.isLetterOrDigit(c1)) {
                ++i;
            }else if(!Character.isLetterOrDigit(c2)) {
                --j;
            } else {
                c1 = Character.toLowerCase(c1);
                c2 = Character.toLowerCase(c2);
                if(c1 != c2)
                    return false;
                ++i;
                --j;
            }
        }
        return true;
    }
}
