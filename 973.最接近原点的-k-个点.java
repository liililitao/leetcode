/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = points.length;//l是点的个数
        for(int i = 0; i < l; i++) {//从小到大冒泡排序
            for(int j = 1; j < l - i; j++) {
                if(points[j-1][0]*points[j-1][0] + points[j-1][1]*points[j-1][1] > points[j][0]*points[j][0] + points[j][1]*points[j][1]) {
                    //互换
                    int t1 = points[j-1][0], t2 = points[j-1][1];
                    points[j-1][0] = points[j][0];
                    points[j-1][1] = points[j][1];
                    points[j][0] = t1;
                    points[j][1] = t2;
                }
            }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {//前k个就是最接近原点的k个点
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
}
// @lc code=end

