import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int minM = 0;
        int n = costs.length;
        int[] delta=new int[n];//差值数组
        for (int i = 0; i < n; i++) {
           minM += costs[i][0];//全部去A市
           delta[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(delta);//对差价排序
        for (int i = 0; i < n/2; i++) {
            minM += delta[i];//将前N个差价加入总费用
        }
        return minM;
    }
}
// @lc code=end

