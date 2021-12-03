package chapter14_dynamic_programming;

/**
 * @author koujn
 * @date 2021/12/3 14:56
 */

/**
 * 题目:一条环形街道上有若干房屋。输入一个数组表示该条街道上的房屋内财产的数量。如果这条街道上相邻的两幢房屋被盗就会自动触发报警系统。
 * 请计算小偷在这条街道上最多能偷取的财产的数量。
 */

/**
 * 可以将这个问题分解成两个子问题:
 * 一个问题是求小偷从标号0开始到标号n-2结束的房屋内能偷得得最多财务数量，
 * 另一个问题是求小偷从标号为1开始到标号n-1结束得房屋内能偷得的最多财务数量。
 * 小偷从标号0开始到标号n-1结束的房屋内能偷得的最多财务数量是这两个子问题的解的最大值。
 */
public class Questions_90 {


    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int result1 = helper(nums,0,nums.length-2);
        int result2 = helper(nums,1,nums.length-1);
        return Math.max(result1,result2);
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        if(start < end)
            dp[1] = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i < end; i++) {
            int j = i - start;
            dp[j%2] = Math.max(dp[(j-2)%2] + nums[j],dp[(j-1)%2]);
        }
        return dp[(end-start)%2];
    }

}
