import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        int len2 = worker.length;
        int[][] works = new int [len][2];
        for(int i=0;i<len;i++){
             works[i][0]=difficulty[i];
             works[i][1]=profit[i];
        }
        Arrays.sort(works,(o1, o2) ->o2[1] - o1[1]);
        Arrays.sort(worker);
        int res = 0;
        int best = 0;
        for(int i=0;i<len2;i++){
            for(int j=0;j<len;j++){
                if(worker[i]>=works[j][0]){
                    best = Math.max(best,works[j][1]);
                }
            }
            res+=best;
        }
        return res;
    }
}
// @lc code=end

