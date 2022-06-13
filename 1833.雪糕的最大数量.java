import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1833 lang=java
 *
 * [1833] 雪糕的最大数量
 */

// @lc code=start
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        //这还不简单，先买最便宜的不就行了
        //秒杀，比简单题还简单
        int l = costs.length, count = 0;
        Arrays.sort(costs);
        for(int i = 0; i < l; i++) {
            if(coins >= costs[i]) {
                coins -= costs[i];
                count++;
            }
            else {
                break;//钱不够，跳出循环
            }
        }
        return count;
    }
}
// @lc code=end

