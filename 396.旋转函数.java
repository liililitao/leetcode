/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        //假设不旋转下的f0的值
        int f0 = 0;
        //当顺序位移一位后，抛出变成0的那个，那么整体增加的
        int sumOfnums = 0;
        for(int i=0;i<n;i++){
            f0 += nums[i] * i;
            sumOfnums += nums[i];
        }
        int max = f0;
        int fi = f0;
        //开始考虑旋转的
        for(int i=1;i<n;i++){
            //旋转后，所有加1
            fi += sumOfnums;
            //上一回合的 最后一个需要减去n个(原来n-1 刚刚又加了一个)
            fi -= n * nums[n - i];
            max = Math.max(max,fi);
        }
        return max;
    }
}
// @lc code=end

