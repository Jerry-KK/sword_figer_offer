package chapter14_dynamic_programming;

/**
 * @author koujn
 * @date 2021/12/3 17:06
 */

/**
 * 题目:输入一个只包含'0'和'1'的字符串,其中,'0'可以翻转成'1'，'1'可以翻转成'0'.请问至少需要翻转几个字符，才可以使翻转之后的字符串种所有的'0'位
 * 于'1'的前面？翻转之后的字符串可能只包含字符'0'和'1'。
 * 例如,输入字符串'00110'，至少需要翻转一个字符才能使所有的'0'位于'1'的前面。可以将最后一个字符'0'翻转成'1'，得到字符串"00111"。
 */
public class Questions_92 {

    public static void main(String[] args) {
        String str = "010110101";
        Questions_92 body = new Questions_92();
        int i = body.test(str);
        System.out.println(i);
    }

    public int test(String str) {
        if(str.length() <= 1)
            return 0;
        int[][] dp = new int[2][2];
        dp[0][0] = str.charAt(0) == '0'? 0 : 1;
        dp[0][1] = str.charAt(0) == '1'? 0 : 1;
        for (int i = 1; i < str.length(); i++) {
            dp[i&1][0] = dp[(i-1)&1][0] + (str.charAt(i) == '0'? 0 : 1);
            dp[i&1][1] = Math.min(dp[(i-1)&1][0],dp[(i-1)&1][1]) + (str.charAt(i) == '1'? 0 : 1);
        }
        int idx = (str.length()-1)&1;
        return Math.min(dp[idx][0],dp[idx][1]);
    }

}
