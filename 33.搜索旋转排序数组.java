/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right) {//二分查找
            int mid = left + (right - left)/2;//中间值
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[right]) {//中间的数小于右边，说明右边有序
                if(nums[mid] < target && target <= nums[right])//在右边
                    left = mid + 1;//左指针=mid+1
                else 
                    right = mid - 1;//在左边，右指针=mid-1
            }
            else {//中间的数大于右边，说明左边有序
                if(nums[left] <= target && target < nums[mid])//在左边
                    right = mid - 1;//右指针=mid-1
                else
                    left = mid + 1;//在右边，左指针=mid+1
            }
        }
        return -1;
    }
}
// @lc code=end

