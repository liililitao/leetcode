/*
 * @lc app=leetcode.cn id=978 lang=java
 *
 * [978] 最长湍流子数组
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len < 2) return len;
        // 以 arr[i] 结尾，并且 arr[i - 1] < arr[i] 的湍流子数组的长度
        int[] increased = new int[len];
        // 以 arr[i] 结尾，并且 arr[i - 1] > arr[i] 的湍流子数组的长度
        int[] decreased = new int[len];
        increased[0] = 1;
        decreased[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] < arr[i]) {
                increased[i] = decreased[i - 1] + 1;
                decreased[i] = 1;
            } else if (arr[i - 1] > arr[i]) {
                decreased[i] = increased[i - 1] + 1;
                increased[i] = 1;
            } else {
                increased[i] = 1;
                decreased[i] = 1;
            }
            res = Math.max(res, Math.max(increased[i], decreased[i]));
        }
        return res;
    }
}
// @lc code=end

