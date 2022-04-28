/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;//本来就满意的
        int maxPretendSatisfied = 0;//最大抑制情绪满意的
        int pretendSatisfied = 0;//窗口内抑制情绪满意的
        for (int i = 0; i < grumpy.length; ++i) {
            //如果grumpy[i]是0，表示顾客是满意的
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                //如果不等于0，表示顾客是不满意的，但老板可以控制自己的
                //情绪，顾客表示假装满意
                pretendSatisfied += customers[i];
            }
            //老板控制自己的情绪是有限的，这个范围我们可以把它看做是一个窗口，
            //这个窗口是一直往右移动的，如果移除窗口的有不满意的，要减去
            if (i >= minutes && grumpy[i - minutes] == 1) {
                pretendSatisfied -= customers[i - minutes];
            }
            //保存通过抑制情绪使顾客满意的最大数量
            maxPretendSatisfied = Math.max(maxPretendSatisfied, pretendSatisfied);
        }
        //最后返回本来就使顾客满意的数量+抑制情绪使顾客满意的数量
        return satisfied + maxPretendSatisfied;
    }
}
// @lc code=end

