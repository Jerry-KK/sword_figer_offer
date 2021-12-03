package chapter14_dynamic_programming;

/**
 * @author koujn
 * @date 2021/12/3 15:12
 */

/**
 * 题目：一排n幢房子要粉刷成红色、绿色和蓝色，不同房子被粉刷成不同颜色的成本不同。用一个n*3的数组表示n幢房子分别用3种颜色粉刷的成本。要求任意相邻的两幢房子的颜色都不一样，
 * 请计算粉刷这n幢房子的最少成本。
 * 例如，粉刷3幢房子的成本分别为[[17,2,16],[15,14,5],[13,3,1]],如果分别将这3幢房子粉刷成绿色、蓝色和绿色，那么粉刷的成本是10，是最少的成本
 */
public class Questions_91 {

    public int test(int[][] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return Math.min(Math.min(nums[0][0],nums[0][1]),nums[0][2]);
        int[] dp = new int[3];
        dp[0] = nums[0][0];
        dp[1] = nums[0][1];
        dp[2] = nums[0][2];
        for (int i = 1; i < nums.length; i++) {
            int[] temp = new int[3];
            temp[0] = Math.min(dp[1],dp[2])+nums[i][0];
            temp[1] = Math.min(dp[0],dp[2])+nums[i][1];
            temp[2] = Math.min(dp[0],dp[1])+nums[i][2];
            dp = temp;
        }
        return Math.min(Math.min(dp[0],dp[1]),dp[2]);
    }
    
    public int minCost(int[][] costs) {
        if(costs.length == 0)
            return 0;
        int[][] dp = new int[3][2];
        for (int j = 0; j < 3; j++) {
            dp[j][0] = costs[0][j];
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                int prev1 = dp[(j+2) % 3][(i-1) % 2];
                int prev2 = dp[(j+1) % 3][(i-1) % 2];
                dp[j][i%2] = Math.min(prev1,prev2) + costs[i][j];
            }
        }
        int last = (costs.length - 1) % 2;
        return Math.min(Math.min(dp[0][last],dp[1][last]),dp[2][last]);
    }

}
