package chapter2_array;

/**
 * @author lethe
 * @date 2021/11/15 23:20
 */

/**
 * 题目：输入一个整数数组，如果一个数字左边的子数组的数字之和等于右边的子数组的数字之和，那么返回该数字的下标。
 * 如果存在多个这样的数字，则返回最左边一个数字的下标。
 * 如果不存在这样的数字，则返回-1。
 * 例如，在数组[1,7,3,6,2,9]中，下标为3的数字(值为6)的左边3个数字1，7，3的和与右边两个数字2和9的和相等，都是11，因此正确的输出值是3。
 */
public class Questions_12 {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums)
            total += num;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum - nums[i] == total - sum)
                return i;
        }
        return -1;
    }

}
