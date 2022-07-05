/*
 * @lc app=leetcode.cn id=1936 lang=java
 *
 * [1936] 新增的最少台阶数
 */

// @lc code=start
class Solution {
    public int addRungs(int[] rungs, int dist) {
        int high=0,num=0;
        if(rungs[0]-dist>high){
            int dis = rungs[0]-high-dist;
            int n = dis/dist;
            if(dis%dist!=0){
                n++;
            }
            num+=n;
        }
        high=rungs[0];
        for(int i=1;i<rungs.length;i++){
            if(rungs[i]>high+dist){
                int dis = rungs[i]-high-dist;
                int n = dis/dist;
                if(dis%dist!=0){
                    n++;
                }
                num+=n;
            }
            high=rungs[i];
        }
        return num;
    }
}
// @lc code=end

