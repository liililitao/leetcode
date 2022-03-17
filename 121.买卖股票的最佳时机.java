/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length - 1;
        if(l <= 0)return 0;
        int s = 0,max = 0;
        for(int j = 0; j < l; j++){
            for(int i = 1; i < l; i++){
                if(prices[j] < prices[j + i]) {
                    s = prices[i + j] - prices[i];
                }
                max = s > max ? s : max;
            }
        }
        return max;
    }
}
// @lc code=end

