package chapter1_integer;

import java.util.Arrays;

/**
 * @author koujn
 * @date 2021/11/15 14:14
 */

/**
 * 题目：输入一个非负数n,请计算0到n之间每个数字的二进制形式中1的个数，并输出一个数组。
 * 例如，输入的n为4，由于0、1、2、3、4的二进制形式中1的个数分别为0、1、1、2、1，因此输出数组[0,1,1,2,1]
 */
public class Questions_3 {

    public static void main(String[] args) {
        Questions_3 body = new Questions_3();
        int[] res = body.countBits3(11);
        Arrays.stream(res).forEach(System.out::println);
    }


    /**
     * 思路： 通过 i & (i-1) 相当于把i最右边的一个1去掉了
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j != 0) {
                arr[i]++;
                j = j & (j-1);
            }
        }
        return arr;
    }

    public int[] countBits2(int n) {
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = arr[i & (i-1)] + 1;
        return arr;
    }

    /**
     * 思路："i/2"相当于将i右移一位的结果，如果i是偶数，最右一位为0，1的个数不变；如果i是奇数，最右边一位为1，1的个数减一
     * 这里代码用 i>>1 计算 i/2 , 用 i&1 计算 i%2 。因为位运算比除法运算和求余运算更高效。
     * @param n
     * @return
     */
    public int[] countBits3(int n) {
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = arr[i>>1] + (i&1);
        return arr;
    }
}
