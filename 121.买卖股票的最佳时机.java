/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;//记录最低点
        int maxprofit = 0;//最大利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];//最低点
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;//更新最大利润
            }
        }
        return maxprofit;
    }
}
// @lc code=end

