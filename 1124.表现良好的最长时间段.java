/*
 * @lc app=leetcode.cn id=1124 lang=java
 *
 * [1124] 表现良好的最长时间段
 */

// @lc code=start
class Solution {
    public int longestWPI(int[] hours) {
        int i,j,len,res = 0;
        int[] presum = new int[10001];
        len = hours.length;
        for(i = 1; i <= len; i++) 
            presum[i] = presum[i-1] + (hours[i-1]>8 ? 1 : -1);
        for(i = 1; i <= len; i++) {
            for(j = 0; j < i; j++) 
                if(presum[i]-presum[j] > 0) 
                    break;
            res = Math.max(res, i-j);
        }
        return res;
    }
}
// @lc code=end

