/*
 * @lc app=leetcode.cn id=1648 lang=java
 *
 * [1648] 销售价值减少的颜色球
 */

// @lc code=start
class Solution {
    static final int mod = (int)1e9 + 7;
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int len = inventory.length;
        long ans = 0, getnum = 0;
        int cnt = 1, lastPrice = inventory[len - 1];
        for (int i = len - 2; i >= 0 && getnum <= orders; --i) {
            // 过滤重复值, 减少计算, 可能导致getnum最终小于orders
            if (inventory[i] == inventory[i + 1]) {
                cnt++;
                continue;
            }
            long diff = inventory[i + 1] - inventory[i];
            if (getnum + diff * cnt >= orders) break; // 超出时中断取
            getnum += diff * cnt; // 得到的球的个数
            lastPrice = inventory[i];
            ans += (inventory[i + 1] + inventory[i] + 1) * diff / 2 * cnt;
            cnt++; // 不同的球个数增加
        }
        long needNum = orders - getnum;
        long n = needNum / cnt; // 还得取n圈
        ans += (lastPrice + lastPrice - n + 1L) * n / 2 * cnt;
        ans += (needNum % cnt) * (lastPrice - n);
        return (int)(ans % mod);
    }
}
// @lc code=end

