package chapter13_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/12/1 13:55
 */

/**
 * 题目：输入一个不含重复数字的数据集合，请找出它的所有子集。
 * 例如，数据集合[1,2]有4个子集，分别是[],[1],[2],[1,2]
 */
public class Questions_79 {

    public static void main(String[] args) {
        Questions_79 body = new Questions_79();
        int[] nums = {1,2};
        List<List<Integer>> subsets = body.subsets(nums);
        System.out.println(1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length == 0)
            return result;
        helper(nums,0,new LinkedList<>(),result);
        return result;
    }

    private void helper(int[] nums,int i,LinkedList<Integer> subset,List<List<Integer>> result) {
        if(i == nums.length) {
            result.add(new LinkedList<>(subset));
        }else {
            helper(nums,i+1,subset,result);
            subset.add(nums[i]);
            helper(nums,i+1,subset,result);
            subset.removeLast();
        }
    }

}
