/*
 * @lc app=leetcode.cn id=73 lang=c
 *
 * [73] 矩阵置零
 */

// @lc code=start


/*
算法思想：如果一个元素为0，那么将其所在行的第一个元素和所在列的第一个元素
都置为0。之后如果某一行的第一个元素为0，那么将这一整行都变为0；如果某一列
的第一个元素为0，那么将这一整列都变为0。由于矩阵的第一行和第一列的元素值
会被修改，所以用两个标记变量分别记录第一行和第一列是否原本包含0
*/

void setZeroes(int** matrix, int matrixSize, int* matrixColSize){
    int m = matrixSize;//行长
    int n = matrixColSize[0];//列长
    int flag_col0 = false, flag_row0 = false;
    for (int i = 0; i < m; i++) {//遍历第一列看是否有0
        if (!matrix[i][0]) {
            flag_col0 = true;//有0
            break;
        }
    }
    for (int j = 0; j < n; j++) {//遍历第一行看是否有0
        if (!matrix[0][j]) {
            flag_row0 = true;//有0
            break;
        }
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (!matrix[i][j]) {
                //将其所在行的第一个元素和所在列的第一个元素都置为0
                matrix[i][0] = matrix[0][j] = 0;
            }
        }
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (!matrix[i][0] || !matrix[0][j]) {//某一行或某一列的第一个元素为0
                matrix[i][j] = 0;//将其整列或整行都置为0
            }
        }
    }
    if (flag_col0) {//原来的第一列有0
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;//第一列都置为0
        }
    }
    if (flag_row0) {//原来的第一行有0
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;//第一行都置为0
        }
    }
}
// @lc code=end

