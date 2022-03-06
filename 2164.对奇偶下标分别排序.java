import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2164 lang=java
 *
 * [2164] 对奇偶下标分别排序
 */

// @lc code=start
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        //easy难度的题确实简单
        int l = nums.length, l1, l2;
        if(l % 2 == 0) {//长度为偶数，奇偶下标的个数都是一半
            l1 = l/2;
            l2 = l/2;
        }
        else {//长度为奇数，偶下标的个数要加1
            l1 = l/2 + 1;
            l2 = l/2;
        }
        int[] nums1 = new int[l1];//存放偶下标的数字
        for(int i = 0, j = 0; i < l; i += 2) {
            nums1[j] = nums[i];
            j++;
        }
        Arrays.sort(nums1);//排序
        int[] nums2 = new int[l2];//存放奇下标的数字
        for(int i = 1, j = 0; i < l; i += 2) {
            nums2[j] = nums[i];
            j++;
        }
        Arrays.sort(nums2);//排序
        for(int i = 0, j = 0, k = l2 - 1; i < l; i++) {
            if(i % 2 == 0) {//偶下标的
                nums[i] = nums1[j];
                j++;
            }
            else {//奇下标的
                nums[i] = nums2[k];//注意奇下标是从大到小排
                k--;
            }
        }
        return nums;
    }
}
// @lc code=end

