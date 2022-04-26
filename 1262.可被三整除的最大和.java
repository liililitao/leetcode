import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1262 lang=java
 *
 * [1262] 可被三整除的最大和
 */

// @lc code=start
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        //状态定义：dp[i][j]：nums[0,...,i]模3余j的最大和
        int[][] dp = new int[n+1][3];
        //状态初始化
        dp[0][0] =0;
        dp[0][1] =Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        //状态转移方程
        for(int i=1;i<=n;i++){
            if(nums[i-1]%3 ==0){
                //能整除的还能整除
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][0]+nums[i-1]);
                //余1的还是余1
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][1]+nums[i-1]);
                //余2的还是余2
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][2]+nums[i-1]);
            }else if(nums[i-1]%3 == 1){
                //要能整除，两种请情况：不加该数就能整除，或者：之前的和整除余2+该数
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]+nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+nums[i-1]);
            }else if(nums[i-1]%3 ==2){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0] + nums[i-1]);
            }

        }
        return dp[n][0];
    }
}
// @lc code=end

