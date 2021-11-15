package chapter2_array;

/**
 * @author lethe
 * @date 2021/11/15 19:58
 */

/**
 * 题目：输入一个正整数组成的数组和一个正整数k，请问数组中和大于或等于k的连续子数组的最短长度是多少?
 * 如果不存在所有数字之和大于或等于k的子数组，则返回0。
 * 例如，输入数组[5,1,4,3],k的值为7，和大于或等于7的最短连续子数组是[4,3],因此输出它的长度2。
 */
public class Questions_8 {

    public int minSubArrayLen(int[] arr,int tar) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (left <= right && sum >= tar) {
                min = Math.min(min,right - left + 1);
                sum -= arr[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
