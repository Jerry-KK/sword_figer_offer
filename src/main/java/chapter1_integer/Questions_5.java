package chapter1_integer;

/**
 * @author koujn
 * @date 2021/11/15 15:19
 */

/**
 * 题目：输入又给字符串数组words，请计算不包含相同字符的两个字符串words[i]和words[j]的长度乘积的最大值。
 * 如果所有字符串都包含至少一个相同字符，那么返回0。
 * 假设字符串中只包含英文小写字母。
 * 例如，输入的字符串数组words为["abcw","foo","bar","fxyz","abcdef"],数组中的字符串"bar"与"foo"没有相同的字符，它们长度的乘积为9.
 * “abcw”与“fxyz”也没有相同的字符，它们长度的乘积为16，这是该数组不包含相同字符的一对字符串的长度乘积的最大值。
 */
public class Questions_5 {

    public static void main(String[] args) {
        String[] strings = {"abcw","foo","bar","fxyz","abcdef"};
        Questions_5 body = new Questions_5();
        int i = body.maxLength(strings);
        System.out.println(i);
        int j = body.maxProduct(strings);
        System.out.println(j);
    }

    public int maxLength(String[] strings) {
        //用int记录每个字母存在数组
        int[] arr = new int[26];
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            for (char c:strings[i].toCharArray()) {
                arr[(int)c-'a'] = arr[(int)c-'a'] | (1<<i);
            }
        }
        for (String s:strings) {
            int x = 0;
            for (char c:s.toCharArray()) {
                x = arr[(int)c-'a'] | x;
            }
            int l = s.length();
            for (int i = 0; i < strings.length; i++) {
                if(((x>>i) & 1) == 0 )
                    if(strings[i].length() * l > max)
                        max = strings[i].length() * l;
            }
        }
        return max;
    }

    /**
     * Java中int型整数的二进制形式有32位，但只需要26位就能表示一个字符串中出现的字符，因此可以用一个int型整数记录某个字符串中出现的字符。
     * 如果字符串中包含'a'，那么整数最右边的数位位1；以此类推。
     * 这样可以快速判断两个字符串是否包含相同的字符。如果两个字符串中包含相同的字符，那么它们对应的整数相同的某个数位都为1，两个整数的与运算将不会等于0。
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i] |= 1<<(c-'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if((flags[i] & flags[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }


}
