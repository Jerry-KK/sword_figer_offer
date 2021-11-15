package chapter2_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lethe
 * @date 2021/11/15 23:11
 */

/**
 * 题目：输入一个只包含0和1的数组，请问如何求0和1的个数相同的最长连续子数组的长度?
 * 例如，在数组[0,1,0]中有两个子数组包含相同个数的0和1，分别是[0,1]和[1,0],它们长度都是2，所以输出2
 */
public class Questions_11 {

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i] == 0 ? -1 : 1;
            if(sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength,i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum,i);
            }
        }
        return maxLength;
    }

}
