import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        int head = 1;//记录每次删除后的第一个数
        int gap = 1;//相邻数的差
        boolean left = true;//从左删为真，从右删为假
        //循环直到最后剩一个数
        while (n > 1)
        {
            //从左边开始移除 or（从右边开始移除，数列总数为奇数）第一个数变为下一个数，否则不变
            if (left || n % 2 != 0) {
                head += gap;//第一个数加上间隔变为下一个数
            }
            gap *= 2; //每次删除后间隔*2
            left = !left; //方向转换
            n /= 2; //每次删除后剩下的个数，每次删除后剩一半
        }
        return head;
    }
}
// @lc code=end

