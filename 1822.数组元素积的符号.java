/*
 * @lc app=leetcode.cn id=1822 lang=java
 *
 * [1822] 数组元素积的符号
 */

// @lc code=start
class Solution {
    public int arraySign(int[] nums) {
        //这啥题，太简单了，秒杀！！！
        int s = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) return 0;
            if(nums[i] < 0) s++;//看有几个负数
        }
        if(s % 2 == 1) return -1;
        else return 1;
    }
}
// @lc code=end

