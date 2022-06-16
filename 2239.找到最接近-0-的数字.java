import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2239 lang=java
 *
 * [2239] 找到最接近 0 的数字
 */

// @lc code=start
class Solution {
    public int findClosestNumber(int[] nums) {
        //简单题果然简单啊，一遍过加秒杀！
        int l = nums.length;
        Arrays.sort(nums);//先从小到大排序
        for(int i = 0; i < l; i++) {
            if(nums[i] > 0) {//第一个大于0的数，也就是最接近0的正数
                if(i != 0 && Math.abs(nums[i-1]) < nums[i])
                    return nums[i-1];
                else
                    return nums[i];
            }
        }
        return nums[l-1];//循坏结束还没返回值，那说明全是负数，直接返回最大负数
    }
}
// @lc code=end

