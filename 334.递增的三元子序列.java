/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    //贪心思想：为了找到递增的三元子序列，first和second应该尽可能地小
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) 
            return false;
        int first = nums[0], second = Integer.MAX_VALUE;
        //赋初始值的时候，已经满足second > first了，现在找第三个数third
        for (int i = 1; i < n; i++) {//核心代码
            int num = nums[i];
            if (num > second) {//如果third比second大，那就是找到了，直接返回true
                return true;
            } else if (num > first) {//如果third比second小，但是比first大，那就把second的值设为third，然后继续遍历找third
                second = num;
            } else {//如果third比first还小，那就把first的值设为third，然后继续遍历找third
                first = num;
            }
        }
        return false;
    }
}
// @lc code=end

