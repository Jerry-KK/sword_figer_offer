package chapter2_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2021/11/15 22:53
 */

/**
 * 题目：输入一个整数数组和一个整数k，请问数组中有多少个数字之和等于k的连续子数组?
 * 例如，输入数组[1,1,1],k的值为2，有两个连续的子数组之和等于2。
 */
public class Questions_10 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k,0);
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
