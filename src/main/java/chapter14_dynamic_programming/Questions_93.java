package chapter14_dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author koujn
 * @date 2021/12/6 15:31
 */

/**
 * 题目：输入一个没有重复数字的单调递增的数组，数组中至少有3个数字，请问数组中最长的斐波那契数列的长度是多少?
 * 例如，如果输入的数组是[1,2,3,4,5,6,7,8]，由于其中最长的斐波那契数列是1、2、3、5、8,因此输出是5。
 */
public class Questions_93 {

    public int lenLongestFibSubseq(int[] A) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i],i);
        }
        int[][] dp = new int[A.length][A.length];
        int result = 2;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(A[i]-A[j],-1);
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;
                result = Math.max(result,dp[i][j]);
            }
        }
        return result > 2 ? result : 0;
    }

}
