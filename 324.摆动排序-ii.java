import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);//排序
        int n = nums.length;
        int[] temp = nums.clone();//中间数组
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = temp[(n - 1) / 2 - i];//偶数下标是小的，从中间依次往左填充
            nums[2 * i + 1] = temp[n - 1 - i];//奇数下标是大的，从最右边依次往左填充
        }
        if (n % 2 == 1) //如果长度是奇数，则最后一个还没填
            nums[n - 1] = temp[0];//填第一个元素
    }
}
// @lc code=end

