/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int end = 0; // 当前跳远能跳到的最远位置
        int temp = 0; // 当前跳了几下
        int maxPos = 0; // 下一次能跳到的最远位置
        for(int i = 0; i < nums.length -1; i++){
        	// 记录能到达的最远位置
            maxPos = Math.max(maxPos, i + nums[i]);
            // i == end 说明当前的这一跳已经跳到了最远 是时候进行下一跳了
            if(i == end){
                end = maxPos;
                temp++;
            }
        }
        return temp;
    }
}
// @lc code=end

