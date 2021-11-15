package chapter1_integer;

/**
 * @author koujn
 * @date 2021/11/15 14:44
 */

/**
 * 题目：输入一个整数数组，数组中只有一个数字出现了一次，而其他数字都出现了3次。请找出那个只出现一次的数字。
 * 例如，如果输入的数组为[0,1,0,1,0,1,100],则只出现一次的数字是100。
 */

/**
 * 思路：一个整数是由32个0或1组成的。我们可以将数组中所有数字的同一位置的数位相加。
 * 如果将出现3次的数字单独拿出来，那么这些出现了3次的数字的任意第i个数位之和都能被3整除。
 *
 * 举一反三：输入一个整数数组，数组中只有一个数字出现m次，其他数字都出现n次。请找出那个唯一出现m次的数字。假设m不能被n整除。
 */
public class Questions_4 {

    public static void main(String[] args) {
        Questions_4 body = new Questions_4();
        int[] nums = {100,1,0,0,1,1,0};
        int i = body.singleNumber(nums);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num:nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num & (1<<i))>>i;
            }
        }
        int result = 0;
        for (int i = 31; i >= 0; --i) {
            result = (result<<1) + bitSums[i]%3;
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        int[] bitSums = new int[32];
        for (int num:nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += ( num >> (31-i) ) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = (result<<1) + bitSums[i]%3;
        }
        return result;
    }
}
