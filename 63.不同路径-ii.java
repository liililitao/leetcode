/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ways = new int[obstacleGrid.length][obstacleGrid[0].length];
		int i = 0;
		int j = 0;
		for (i = 0; i < obstacleGrid.length; i++) {
			for (j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {//障碍物
					ways[i][j] = 0;//路径为0，因为无法到达障碍物
				} else if (i == 0 && j == 0) {//机器人的起点
					ways[i][j] = 1;//赋值为1
				} else if (i == 0 && j > 0) {//第一排
					ways[i][j] = ways[i][j - 1];//由它左边的那格决定
				} else if (j == 0 && i > 0) {//第一列
					ways[i][j] = ways[i - 1][j];//由它上面的那格决定
				} else {//其余情况和上道题一样
					ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
				}
			}
		}
		return ways[i - 1][j - 1];
    }   
}
// @lc code=end

