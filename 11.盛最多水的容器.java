import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        //用两个指针逐渐向中间移动，这样可以保证宽度是最大的
        int l = height.length, result = 0;
        int left = 0, right = l - 1;//左指针，右指针
        while(left < right) {
            //时刻保持result是最大值
            result = Math.max(Math.min(height[left], height[right]) * (right - left), result);
            //保留较高的那个
            if(height[left] > height[right])//左边高
                right--;//右指针左移
            else//右边高
                left++;//左指针右移
        }
        return result;
    }
}
// @lc code=end

