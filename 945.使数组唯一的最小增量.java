import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int count = 0, l = nums.length;
        Arrays.sort(nums);//排序
        int a = nums[0];//a用来存放nums[i]的前一个元素
        //我们的目的是把数组变成一个没有重复元素的递增数组
        for(int i = 1; i < l; i++) {
            if(nums[i] < a + 1) {//如果比前一个元素+1小
                count += a+1 - nums[i];//每次操作只能加1，所以需要a+1 - nums[i]次操作
                nums[i] = a+1;//让它=前一个元素+1
            }
            a = nums[i];//更新a
        }
        return count;
    }
}
// @lc code=end

