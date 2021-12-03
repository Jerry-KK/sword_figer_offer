package chapter14_dynamic_programming;

/**
 * @author koujn
 * @date 2021/12/3 14:24
 */

/**
 * 题目：输入一个数组表示某条街道上的一排房屋内财产的数量。如果这条街道上相邻的两幢房屋被盗就会自动触发报警系统。请计算小偷在这条街道上最多能偷取到多少财产。
 * 例如，街道上5幢房屋内的财产用数组[2,3,4,5,3]表示，如果小偷到下标为0、2和4的房屋内偷窃，那么他能偷取到价值为9的财务，这是他在不触发报警系统的情况
 * 下能偷取到的最多的财务。
 */
public class Questions_89 {

    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[2];
        dp[0] = nums[0];
        if(nums.length > 1)
            dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i%2] = Math.max(dp[(i-2)%2]+ nums[i],dp[(i-1)%2]) ;
        }
        return dp[(nums.length-1)%2];
    }

}
