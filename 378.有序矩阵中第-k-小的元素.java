import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    //额。。。最笨的方法。呜呜呜
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);//排序
        return list.get(k - 1);//第k小的元素
    }
}
// @lc code=end

