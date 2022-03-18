import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if (matrix.length == 0) {
            return result;
        }
        int rowNum = matrix.length, colNum = matrix[0].length;
        int left = 0;//左边
        int right = colNum - 1;//右边
        int top = 0;//上边
        int dop = rowNum - 1;//下边
        while (result.size() < rowNum * colNum) {
            //最上面的从最左边到最右边 横
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            //最上面的一行已经加完了 上边向下走一行所以++
            top++;
            //最右面的 从最上到最下 竖 判断它是否已经存放完毕
            if (result.size() < rowNum * colNum) {
                for (int row = top; row <= dop; row++) {
                    result.add(matrix[row][right]);
                }
                //最右面的走完一行了继续向中间缩 所以进行--
                right--;
            }
            //最下面的 从最右到最左 判断它是否已经存放完毕
            if (result.size() < rowNum * colNum) {
                for (int colh = right; colh >= left; colh--) {
                    result.add(matrix[dop][colh]);
                }
                //最下面的走完一行了继续向上间缩 所以进行--
                dop--;
            }
            //最左面的 从最下到最上 判断它是否已经存放完毕
            if (result.size() < rowNum * colNum) {
                for (int rows = dop; rows >= top; rows--) {
                    result.add(matrix[rows][left]);
                }
                //最右面的走完一行了继续向右间缩 所以进行--
                left++;
            }
        }
        return result;
    }
}
// @lc code=end

