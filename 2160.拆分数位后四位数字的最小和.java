import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2160 lang=java
 *
 * [2160] 拆分数位后四位数字的最小和
 */

// @lc code=start
class Solution {
    public int minimumSum(int num) {
        //这题太简单了，果然是属于easy难度里面的题
        int[] nums = new int[4];//已经告诉是四位整数了，直接定义长度为4的数组
        for(int i = 0; i < 4; i++) {
            nums[i] = num % 10;//把每一位都存放到数组中
            num /= 10;
        }
        Arrays.sort(nums);//从小到大排序
        //要想两个整数和最小，肯定是两个最小的二位数相加
        return nums[0]*10 + nums[2] + nums[1]*10 + nums[3];
    }
}
// @lc code=end

