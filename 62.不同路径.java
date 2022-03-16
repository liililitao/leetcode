/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        //这个二维数组就表示这个网格，每一个数表示走到这一格有多少条不同的路径
        int[][] step = new int[m][n];
        for(int i = 0; i < m; i++) {
            step[i][0] = 1;//第一列全部赋初值为1，因为只有一种路径就是一直向下走
        }
        for(int i = 0; i < n; i++) {
            step[0][i] = 1;//第一行全部赋初值为1，因为只有一种路径就是一直向右走
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                //除第一行和第一列外，其他格的路径实际上就是它左边和上面的路径之和
                //因为机器人只能向下或者向右走，所以走到这一格只能是从它左边走过来或者是从它上面走下来
                step[i][j] = step[i][j - 1] + step[i - 1][j];
            }
        }
        return step[m - 1][n - 1];//返回右下角的路径
    }
}
// @lc code=end

