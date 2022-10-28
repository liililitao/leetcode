/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int res = 0;
        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < n; i++) {
                matrix[index[0]][i]++;//ri 行上的所有单元格，加 1
            }
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]]++;//ci 列上的所有单元格，加 1
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 == 1) {//奇数
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

