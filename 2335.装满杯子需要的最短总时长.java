import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2335 lang=java
 *
 * [2335] 装满杯子需要的最短总时长
 */

// @lc code=start
class Solution {
    //只需每次都先装 需要装满的杯子数量最多的那两种水就可以
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int count = 0;
        while(amount[1] > 0) {//前两种水都装满后跳出循环
            amount[1]--;
            amount[2]--;
            count++;
            Arrays.sort(amount);//每次都要重新排序
        }
        count += amount[2];//再加上最后一种水
        return count;
    }
}
// @lc code=end

