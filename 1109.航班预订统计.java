/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    //啊哈哈哈，这题也太简单了，秒杀！！！
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        int l = bookings.length;
        for(int i = 0; i < l; i++) {
            for(int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                answer[j - 1] += bookings[i][2];//因为航班号是从1开始编号，而数组下标从0开始，所以j要减1
            }
        }
        return answer;
    }
}
// @lc code=end

