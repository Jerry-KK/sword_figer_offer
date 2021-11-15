package chapter1_integer;

/**
 * @author koujn
 * @date 2021/11/15 11:26
 */

/**
 * 题目：输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。
 * 例如，输入的二进制字符串分别是"11"和"10",则输出"101"。
 */
public class Questions_2 {

    public static void main(String[] args) {
        Questions_2 body = new Questions_2();
        String res = body.addBinary("10", "11");
        System.out.println(res);
    }
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() -1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        if(carry == 1)
            result.append(1);
        return result.reverse().toString();
    }
}
