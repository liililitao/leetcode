/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n]; // 为true表示能到达该位置，为false表示不能到达的位置
        dp[0][0] = true;
		/* 优化的理解：
		 * 每次跳跃，青蛙所在的石子位置至少增加 1，
		 * 而每次跳跃距离至多增加1, 跳跃 m 次后，青蛙现在所处的石子编号i, i>=m 
		 * 上一次跳跃距离k, k≤m，因此 k <= i
		 */
        // 优化： 第i个石子 与第 i-1 个石子距离超过 i 时，青蛙必定无法到达终点
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) { // 现在所处的石子位置（索引）
            for (int j = i - 1; j >= 0; j--) { // 上一次青蛙所处的石子位置（索引）
                int k = stones[i] - stones[j]; // 上一次跳跃距离
                if (k > j + 1) {
                    break;
                }
                // 如果上一次跳跃距离 为 k-1,k,k+1 三者之一，则dp[i][k]可达
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (dp[n - 1][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

