/*
 * @lc app=leetcode.cn id=1310 lang=java
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
class Solution {
    //太简单了！！！一遍过！！！
    public int[] xorQueries(int[] arr, int[][] queries) {
        int lq = queries.length;
        int[] res = new int[lq];// 0 异或 任何数 = 任何数
        for(int i = 0; i < lq; i++) {
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                res[i] = res[i] ^ arr[j];
            }
        }
        return res;
    }
}
// @lc code=end

