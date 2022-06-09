import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1753 lang=java
 *
 * [1753] 移除石子的最大得分
 */

// @lc code=start
class Solution {
    public int maximumScore(int a, int b, int c) {
        int min = 0, middle = 0, max = 0, count = 0;
        int[] m = new int[3];
        m[0] = a;
        m[1] = b;
        m[2] = c;
        Arrays.sort(m);
        min = m[0];
        middle = m[1];
        max = m[2];
        while(true) {//每次都是把三个数中最小的和最大的减1
            if(min > 0) {
                min--;//最小的永远是最小的，一直减1直到0
                if(max < middle)
                    middle--;
                else//谁大减谁
                    max--;
                count++;//得分加1
            }
            else {//最小的那堆减为0了，那得分直接加剩下的两堆中小的那个
                count += Math.min(max, middle);
                break;//两堆为0，退出循环
            }
        }
        return count;
    }
}
// @lc code=end

