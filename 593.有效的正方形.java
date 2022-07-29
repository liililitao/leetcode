import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
class Solution {
    //so easy啦！！！
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int l1,l2,l3,l4,l5,l6;
        l1 = distance(p1, p2);
        l2 = distance(p1, p3);
        l3 = distance(p1, p4);
        l4 = distance(p2, p3);
        l5 = distance(p2, p4);
        l6 = distance(p3, p4);
        if(l1 == 0 || l2 == 0 || l3 == 0 || l4 == 0 || l5 == 0 || l6 == 0)
            return false;//只要有任意两点之间距离为0，那就肯定不是正方形
        int[] l = {l1,l2,l3,l4,l5,l6};
        Arrays.sort(l);//排序，前四个是边长的平方，后两个是对角线长度的平方
        if(l[0] == l[1] && l[1] == l[2] && l[2] == l[3] && l[4] == l[5] && l[5] == 2 * l[0])
            return true;//前四个边长相等，后两个对角线相等，且对角线的平方是边长平方的2倍，则一定是正方形
        return false;
    }
    int distance(int[] a, int[] b) {//返回任意两点之间距离的平方
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
// @lc code=end

