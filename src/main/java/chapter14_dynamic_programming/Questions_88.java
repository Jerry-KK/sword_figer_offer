package chapter14_dynamic_programming;

/**
 * @author koujn
 * @date 2021/12/2 16:57
 */

/**
 * 题目:一个数组cost的所有数字都是正数，它的第i个数字表示在一个楼梯的第i级台阶往上爬的成本，在支付了成本cost[i]之后可以从第i级台阶往上爬1级或2级。
 * 假设台阶至少有2级，既可以从第0级台阶出发，也可以从第1级台阶
 */
public class Questions_88 {

    public int test(int[] nums) {
        for (int i = 2; i < nums.length; i++) {
            nums[i] += Math.min(nums[i-1],nums[i-2]);
        }
        return Math.min(nums[nums.length-1],nums[nums.length-2]);
    }

    //递归代码 效率低 存在重复计算
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        return Math.min(helper(cost,len-2),helper(cost,len-1));
    }

    private int helper(int[] cost, int i) {
        if(i < 2) {
            return cost[i];
        }
        return Math.min(helper(cost,i-2),helper(cost,i-1)) + cost[i];
    }

    //用一个长度为2的数组保存结果，空间复杂度为O(1)
    public int minCostClimbingStairs2(int[] cost) {
        int[] dp = new int[] {cost[0],cost[1]};
        for (int i = 2; i < cost.length; i++) {
            dp[i%2] = Math.min(dp[0],dp[1]) + cost[i];
        }
        return Math.min(dp[0],dp[1]);
    }

}
