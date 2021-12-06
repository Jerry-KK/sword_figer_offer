package chapter14_dynamic_programming;


/**
 * @author koujn
 * @date 2021/12/6 16:28
 */

/**
 * 题目：输入两个字符串，请求出它们的最长公共子序列的长度。如果从字符串s1中删除若干字符之后能得到字符串s2，那么字符串s2就是字符串s1的一个子序列。
 * 例如，从字符串"abcde"中删除两个字符之后能得到字符串"ace"，因此字符串"ace"是字符串"abcde"的一个子序列。但字符串"aec"不是字符串"abcde"的子序列。
 * 如果输入字符串”abcde“和”badfe“，那么它们的最长公共子序列是"bde"，因此输入3。
 */
public class Questions_95 {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 < len2) {
            return longestCommonSubsequence2(text2, text1);
        }
        int[][] dp = new int[2][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[(i+1)%2][j+1] = dp[i%2][j] + 1;
                }else {
                    dp[(i+1)%2][j+1] = Math.max(dp[(i+1)%2][j],dp[(i)%2][j+1]);
                }
            }
        }
        return dp[len1%2][len2];
    }

    public int longestCommonSubsequence3(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 < len2) {
            return longestCommonSubsequence3(text2, text1);
        }
        int[] dp = new int[len2+1];
        for (int i = 0; i < len1; i++) {
            int prev = dp[0];
            for (int j = 0; j < len2; j++) {
                int cur;
                if(text1.charAt(i) == text2.charAt(j)) {
                    cur = prev + 1;
                }else {
                    cur = Math.max(dp[j],dp[j+1]);
                }
                prev = dp[j+1];
                dp[j+1] = cur;
            }
        }
        return dp[len2];
    }

}
