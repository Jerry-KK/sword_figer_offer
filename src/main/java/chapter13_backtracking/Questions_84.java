package chapter13_backtracking;

/**
 * @author lethe
 * @date 2021/12/1 21:27
 */

import java.util.*;

/**
 * 题目:给定一个包含重复数字的集合,请找出它的所有全排序。
 * 例如，集合[1,1,2]有3个全排序，分别是[1,1,2]、[1,2,1]和[2,1,1]
 */
public class Questions_84 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums,0,result);
        return result;
    }

    private void helper(int[] nums, int i, List<List<Integer>> result) {
        if( i == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num :nums) {
                permutation.add(num);
            }
            result.add(permutation);
        }else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; ++j) {
                if(!set.contains(nums[j])) {
                    set.add(nums[j]);

                    swap(nums,i,j);
                    helper(nums,i+1,result);
                    swap(nums,i,j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
