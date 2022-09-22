import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 */

// @lc code=start
class Solution {
    //啊哈哈哈哈，秒杀了！！！其实就是让你找中位数！
    public int minMoves2(int[] nums) {
        int l = nums.length;
        int num = 0;//中位数
        Arrays.sort(nums);
        if(l % 2 == 0)//偶数个元素
            num = (nums[l / 2 - 1] + nums[l / 2]) / 2;//中位数是中间两个数除以2
        else //奇数个元素
            num = nums[l / 2];//中间那个数就是中位数
        int sum = 0;
        for(int i = 0; i < l; i++) {
            sum += Math.abs(nums[i] - num);//绝对值
        }
        return sum;
    }   
}
// @lc code=end

