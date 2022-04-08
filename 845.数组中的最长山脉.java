/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] A) {
        // 少于3个不能组成山脉，直接返回0
        int aLen = A.length;
        if (aLen < 3)   return 0;
		// 贪心
        int maxLen = 0; // 记录最长的山脉的组成个数
        // 根据题意，我们知道山脉需要两边都小于高点，所以从1开始，到倒数第二个结束
        for (int i = 1; i < aLen - 1; i++) {
            // 剪枝，如果有一边一开始就大于等于高点，进入下个循环
            if (A[i - 1] >= A[i] || A[i + 1] >= A[i]) {
                continue;
            }
            // 循环比较，得出左边的长度
            int leftLen = 0;
            int leftIndex = i - 1;
            while (leftIndex >= 0 && A[leftIndex] < A[leftIndex + 1]) {
                leftLen++;  // 长度加1
                leftIndex--;    // 下标减1
            }
            // 循环比较，得出右边的长度
            int rightLen = 0;
            int rightIndex = i + 1;
            while (rightIndex < aLen && A[rightIndex] < A[rightIndex - 1]) {
                rightLen++; // 长度加1
                rightIndex++;   // 下标加1
            }
            // 左边长度+右边长度+1 和 maxLen 比较，保存大的值（加1是加上最高点）
            maxLen = Math.max(maxLen, leftLen + rightLen + 1);
        }
        return maxLen;
    }
}
// @lc code=end

