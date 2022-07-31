/*
 * @lc app=leetcode.cn id=1739 lang=java
 *
 * [1739] 放置盒子
 */

// @lc code=start
class Solution {
    public int minimumBoxes(int n) {
        int bottom = 1;
        for (int sum = 1, height = 1; sum < n; height++) {
            for (int i = 0; i <= height && sum < n; i++) { // 每次增加 1 个底部盒子
                bottom++;
                sum += i + 1; // i 个是在上方堆叠的，不与地面接触
            }
        }
        return bottom;
    }
}
// @lc code=end

