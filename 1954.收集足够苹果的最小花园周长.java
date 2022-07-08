/*
 * @lc app=leetcode.cn id=1954 lang=java
 *
 * [1954] 收集足够苹果的最小花园周长
 */

// @lc code=start
class Solution {
    public long minimumPerimeter(long neededApples) {
        long left = 1;
        long right = (long)Math.pow(10, 5);
        long mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            long result = 2 * mid * (mid + 1) * (2 * mid + 1);
            if (result >= neededApples) {
                right = mid;
            } else if (result < neededApples) {
                left = mid + 1;
            }
        }
        return right * 8;
    }
}
// @lc code=end

