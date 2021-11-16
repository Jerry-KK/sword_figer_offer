package chapter3_string;

/**
 * @author koujn
 * @date 2021/11/16 17:34
 */


/**
 * 题目：输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。
 * 例如，输入字符串"babcca"，其最长的不含重复字符的子字符串是"abc",长度为3。
 */
public class Questions_16 {

    public static void main(String[] args) {
        Questions_16 body = new Questions_16();
        int max = body.getMax("babcca");
        System.out.println(max);
    }

    /**
     * 我的解法，双指针，扫描过的字符如果数组中为0，改为1，
     * 如果遇到数组中为1，说明前面有一个这样的字符，把第二个指针移动到前一个相同字符的位置两个指针都加一
     * @param str
     * @return
     */
    public int getMax(String str) {
        if(str.length() < 2)
            return str.length();
        int max = 1;
        int i = 0;
        int j = 0;
        int[] arr = new int[26];
        while (j < str.length()) {
            if(arr[str.charAt(j) -'a'] == 1) {
                max = Math.max(max,j-i);
                while (str.charAt(i) != str.charAt(j))
                    arr[str.charAt(i++)-'a'] = 0;
                ++i;
                ++j;
            }else {
                arr[str.charAt(j++) -'a'] = 1;
            }
        }
        max = Math.max(max,j-i);
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        for (; i < s.length(); ++i) {
            ++counts[s.charAt(i)];
            while (hasGreaterThan1(counts)) {
                ++j;
                --counts[s.charAt(j)];
            }
            longest = Math.max(i - j,longest);
        }
        return longest;
    }

    private boolean hasGreaterThan1(int[] counts) {
        for (int count:counts) {
            if(count > 1)
                return true;
        }
        return false;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0)
            return 0;
        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        int countDup = 0;
        for( ; i < s.length(); ++i) {
            ++counts[s.charAt(i)];
            if(counts[s.charAt(i)] == 2) {
                ++countDup;
            }
            while (countDup > 0){
                ++j;
                --counts[s.charAt(j)];
                if(counts[s.charAt(j)] == 1) {
                    --countDup;
                }
            }
            longest = Math.max(longest,i-j);
        }
        return longest;
    }
}
