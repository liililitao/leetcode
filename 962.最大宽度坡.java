/*
 * @lc app=leetcode.cn id=962 lang=java
 *
 * [962] 最大宽度坡
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        int l = nums.length;
        int k = 0, max = 0;
        for(int j = l - 1; j > 0; j--) {//从最后一个元素开始
            for(int i = 0; i < j; i++) {//从第一个元素向j靠拢
                if(nums[i] <= nums[j]) {//满足条件
                    k = j - i;
                    break;//不用再往后找了，后面的j-i只会越来越小
                }
            }
            max = Math.max(max, k);//储存最大值
        }
        return max;
    }
}
// @lc code=end

