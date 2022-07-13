/*
 * @lc app=leetcode.cn id=2086 lang=java
 *
 * [2086] 从房屋收集雨水需要的最少水桶数
 */

// @lc code=start
class Solution {
    public int minimumBuckets(String street) {
        if ("H".equals(street) || street.startsWith("HH") || street.endsWith("HH") || street.contains("HHH")) {
            return -1;//把无解的情况先排除掉
        }
        int res = 0;
        for (char c : street.toCharArray()) {//一个房子一桶水
            if (c == 'H') {
                ++res;
            }
        }
        for (int i = 0; i < street.length() - 2; ++i) {//若两个房子可以共用一桶水，则答案减1，同时注意跳过H.H
            if (street.charAt(i) == 'H' && street.charAt(i+1)=='.' && street.charAt(i+2)=='H') {
                --res;
                i += 2;
            }
        }
        return res;
    }
}
// @lc code=end

