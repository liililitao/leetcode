/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        // 最佳观光组合的值
    	int max = 0;
    	// 遍历过程中A[i] + i的最大值
    	int max_i = 0;
    	for (int j = 1; j < A.length; j++) {
    		max_i = A[j-1] + j -1 > max_i ? A[j-1] + j -1 : max_i;
    		max = A[j] - j + max_i > max ? A[j] - j + max_i : max;
    	}
    	return max;
    }
}
// @lc code=end

