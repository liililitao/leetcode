/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {//每个元素都要弄
            int cnt = 0;
            while (!vis[i]) {//没访问过
                vis[i] = true;//置为访问过
                i = nums[i];
                ++cnt;//长度加1
            }
            ans = Math.max(ans, cnt);//取最大值
        }
        return ans;
    }
}
// @lc code=end

