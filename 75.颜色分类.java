/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        //因为数组中只有012，所以只用一层循环即可
        int l = nums.length;
        int[] nums2 = new int[l];//中间数组，存放排序后的值
        int k = 0, j = l - 1;//左指针，右指针
        for(int i = 0; i < l; i++) {
            if(nums[i] == 0) {//0，最小
                nums2[k] = 0;
                k++;//左指针加1
            }
            else if(nums[i] == 2) {//2，最大
                nums2[j] = 2;
                j--;//右指针减1
            }
        }
        //0和2都填完了，剩下的全部是1
        for(int i = k; i <= j; i++) {
            nums2[i] = 1;
        }
        for(int i = 0; i < l; i++)
            nums[i] = nums2[i];//将排序后的数组赋给原来的nums
    }
}
// @lc code=end

