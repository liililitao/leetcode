/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    //这太简单了吧，秒杀加一遍过！！！
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int[] res = new int[l];
        for(int i = 0; i < l; i++) {
            for(int j = i + 1; j < l; j++) {
                if(temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

