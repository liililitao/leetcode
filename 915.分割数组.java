import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=915 lang=java
 *
 * [915] 分割数组
 */

// @lc code=start
class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax=nums[0];
        int Max=nums[0];
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            Max=Math.max(Max,nums[i]); //维护当前扫描到的全局最大值
            if(nums[i]<leftMax) //出现比之前left数组里最大的数小的数，则这个数必须添加进left数组
            {
                result=i;
                leftMax=Max;
            }
        }
        return result+1;
    }
}
// @lc code=end

