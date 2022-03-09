/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;//能到达的最远位置
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(maxIndex < i) return false;//能到达的最远的位置比i小，说明到不了i，更到不了最后一个下标
            if(maxIndex < i+nums[i]) maxIndex = i+nums[i];//更新能到达的最远位置
        }
        return true;
    }
}
// @lc code=end

