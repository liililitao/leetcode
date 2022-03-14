import javax.lang.model.element.Element;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*这里用到了一个binarySearch方法，但这个方法无法准确找到该数值
        的最后一个索引或第一个索引，所以在后面还要向前向后查找*/
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) //i < 0，没找到
            return new int[]{-1,-1};
        int begin = i;//开始位置
        int end = i;//结束位置
        while (begin-1 >= 0 && nums[begin-1] == target) {
            begin--;
        }
        while (end+1 < nums.length && nums[end+1] == target) {
            end++;
        }
        return new int[]{begin,end};
    }
}
// @lc code=end

