/*
 * @lc app=leetcode.cn id=1010 lang=java
 *
 * [1010] 总持续时间可被 60 整除的歌曲
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] record = new int[60];//record[i]表示余数为i的个数
        int count = 0;
        for(int t : time){
            t %= 60; //求这个时间除以60的余数
            if(t != 0)  
                count += record[60 - t];//如果余数不为0，找出相加为0的余数总和相加
            else count += record[t];//如果为0，加其他为0的数
            record[t]++;
        }
        return count;
    }
}
// @lc code=end

