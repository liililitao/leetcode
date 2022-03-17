/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        //初始为1，因为1乘以任何数都是1
        int imax=1;
        int imin=1;
        for(int i=0;i<nums.length;i++)
        {
            //如果是负数，那么最大值和最小值互换
            if(nums[i]<0)
            {
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            //看看是否从当前值开始
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            //不断更新最大值
            max=Math.max(max,imax);
        }
        return max;
    }
}
// @lc code=end

