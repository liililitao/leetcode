import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1953 lang=java
 *
 * [1953] 你可以工作的最大周数
 */

// @lc code=start
class Solution {
    public long numberOfWeeks(int[] milestones) {
/*因为可任意安排各个项目的参与顺序，所以当且仅当其中某一项目的阶段任务数量max超过总任务量sum的一半时，我们无法完成全部任务。
根据这一特点，可直接结合贪心算法求解：
若不存在超过任务总量一半的项目，即max <= half时，所有项目都可被完成，最长工作时间为 sum ；
若存在超过任务总量一半的项目，即max > half时，该项目无法被完成，最长工作时间为剩余项目总时间 * 2 + 1，即 (sum - max) * 2 + 1 */
        int l = milestones.length;
        long sum = 0;
        if(l==1) return 1;
        for(int i = 0; i < l; i++)
            sum += milestones[i];
        long half = sum / 2;
        Arrays.sort(milestones);
        long max = milestones[l-1];
        if(max <= half)
            return sum;
        else
            return 2*(sum-max)+1;
    }
}
// @lc code=end

