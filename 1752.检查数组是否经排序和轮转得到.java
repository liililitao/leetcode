import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1752 lang=java
 *
 * [1752] 检查数组是否经排序和轮转得到
 */

// @lc code=start
class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        boolean firstArr = true;//标记是否已经过轮转
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                if (firstArr == false)//需第二次轮转，不符合
                    return false;
                firstArr = false;
            }
        }
        if (firstArr == false && nums[len - 1] > nums[0])//轮转后首尾端连接时无法满足非递减
            return false;
        return true;
    }
}
// @lc code=end

