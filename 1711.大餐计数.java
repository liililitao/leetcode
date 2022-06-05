/*
 * @lc app=leetcode.cn id=1711 lang=java
 *
 * [1711] 大餐计数
 */

// @lc code=start
class Solution {
    public int countPairs(int[] deliciousness) {
        int mod = (int)1e9 + 7, ans = 0, maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();//记录已遍历过的餐品及数量
        for (int num : deliciousness) {
            maxSum = Math.max(maxSum, num << 1);//当前可能达到的2的最大幂
            for (int i = 1; i <= maxSum; i <<= 1) {//遍历2的各个幂
                if (i >= num && map.containsKey(i - num))//存在可组合得到大餐的其他餐品
                    ans = (ans + map.get(i - num)) % mod;//添加对应其他餐品的数量
            }
            map.put(num, map.getOrDefault(num, 0) + 1);//加入当前餐品
        }
        return ans;
    }
}
// @lc code=end

