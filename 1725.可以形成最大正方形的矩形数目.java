import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1725 lang=java
 *
 * [1725] 可以形成最大正方形的矩形数目
 */

// @lc code=start
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        //无聊！！！
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < rectangles.length; i++) {
            list.add(Math.min(rectangles[i][0], rectangles[i][1]));
        }
        int max = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(max < list.get(i)) {
                max = list.get(i);//找到最大的边长
            }
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == max) {
                sum++;//统计最大的边长的数目
            }
        }
        return sum;
    }
}
// @lc code=end

