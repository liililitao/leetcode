import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    //我的天哪，秒杀加一遍过，还beat100%！！！这中等题也太简单了！
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> list = new ArrayList<>();
        int l1 = matrix.length, l2 = matrix[0].length;
        for(int i = 0; i < l1; i++) {
            for(int j = 0; j < l2; j++) {
                list.add(matrix[i][j]);//都放入list中
            }
        }
        if(list.contains(target))
            return true;
        else
            return false;
    }
}
// @lc code=end

