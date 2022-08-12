import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2289 lang=java
 *
 * [2289] 使数组按非递减顺序排列
 */

// @lc code=start
class Solution {
    public int totalSteps(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                // 记录当前下标元素入栈时的出栈次数
                dp[i] = Math.max(dp[i] + 1, dp[stack.pop()]);
                res = Math.max(res, dp[i]);
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

