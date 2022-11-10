import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2357 lang=java
 *
 * [2357] 使数组中所有元素都等于零
 */

// @lc code=start
class Solution {
    //其实 x 就是 nums 中的最小非零元素
    public int minimumOperations(int[] nums) {
        int l = nums.length;
        int count = 0;
        Arrays.sort(nums);//升序排序
        for(int i = 0; i < l; i++) {
            if(nums[i] > 0) {//最小非零元素
                int x = nums[i];// x 充当临时变量
                for(int j = i; j < l; j++) {
                    nums[j] -= x;//每个正整数都减去 x
                }
                count++;//操作数加 1
            }
        }
        return count;
    }
}
// @lc code=end

