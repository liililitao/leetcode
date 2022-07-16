/*
 * @lc app=leetcode.cn id=2293 lang=java
 *
 * [2293] 极大极小游戏
 */

// @lc code=start
class Solution {
    //简单，按照题目要求做就行了
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while(n > 1) {
            n /= 2;
            int[] nums2 = new int[n];
            for(int i = 0, j = 0; j < n; i += 2, j++) {
                if(j % 2 == 0)//偶数下标，min
                    nums2[j] = Math.min(nums[i], nums[i+1]);
                else//奇数下标，max
                    nums2[j] = Math.max(nums[i], nums[i+1]);
            }
            for(int i = 0; i < n; i++) {
                nums[i] = nums2[i];//更新nums，让其=nums2
            }
        }
        return nums[0];//返回最后剩下的那一个数字
    }
}
// @lc code=end

