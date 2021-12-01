package chapter13_backtracking;

/**
 * @author koujn
 * @date 2021/12/1 15:28
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：给定一个没有重复数字的正整数集合，请找出所有元素之和等于某个给定值的所有组合。
 * 同一个数字可以在组合中出现任意次。
 * 例如，输入整数集合[2,3,5],元素之和等于8的组合有3个，分别是[2,2,2,2]、[2,3,3]和[3,5].
 *
 */
public class Questions_81 {
    public static void main(String[] args) {
        Questions_81 body = new Questions_81();
        int[] nums = {2,3,5};
        List<List<Integer>> lists = body.myTest(nums, 8);
        System.out.println(1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(nums,target,0,combination,result);
        return result;
    }

    private void helper(int[] nums, int target, int i, LinkedList<Integer> combination,List<List<Integer>> result) {
        if(target == 0) {
            result.add(new LinkedList<>(combination));
        }else if(target > 0  && i < nums.length) {
            helper(nums,target,i+1,combination,result);
            combination.add(nums[i]);
            helper(nums,target-nums[i],i,combination,result);
            combination.removeLast();
        }
    }


    public List<List<Integer>> myTest(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        myHelp(nums,target,0,0,new LinkedList<>(),result);
        return result;
    }

    public void myHelp(int[] nums, int target, int i,int sum, LinkedList<Integer> list,List<List<Integer>> result) {
        if(sum >= target) {
            if(sum == target) {
                result.add(new LinkedList<>(list));
            }
        }else {
            while (i < nums.length) {
                list.add(nums[i]);
                myHelp(nums,target,i,sum+nums[i],list,result);
                list.removeLast();
                i++;
            }
        }
    }
}
