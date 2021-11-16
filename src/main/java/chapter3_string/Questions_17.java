package chapter3_string;

import java.util.HashMap;

/**
 * @author lethe
 * @date 2021/11/16 22:54
 */
public class Questions_17 {

    public static void main(String[] args) {
        String s1 = "ADDBANCAD";
        String s2 = "ABC";
        Questions_17 body = new Questions_17();
        String minStr = body.minWindow(s1, s2);
        System.out.println(minStr);

    }

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> charToCount = new HashMap<>();
        for (char ch:t.toCharArray()) {
            charToCount.put(ch,charToCount.getOrDefault(ch,0)+1);
        }
        int count = charToCount.size();
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < s.length() || (count == 0 && end == s.length())) {
            if(count > 0) {
                char endCh = s.charAt(end);
                if(charToCount.containsKey(endCh)) {
                    charToCount.put(endCh, charToCount.get(endCh) - 1);
                    if(charToCount.get(endCh) == 0) {
                        --count;
                    }
                }
                ++end;
            }else {
                if(end - start < minLength) {
                    minEnd = end;
                    minStart = start;
                    char startCh = s.charAt(start);
                    if(charToCount.containsKey(startCh)) {
                        charToCount.put(startCh,charToCount.get(startCh) + 1);
                        if(charToCount.get(startCh) == 1) {
                            ++count;
                        }
                    }
                    start++;
                }
            }
        }
        return minLength < Integer.MAX_VALUE ? s.substring(minStart,minEnd) : "";
    }


}
