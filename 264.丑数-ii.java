import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int f[] = new int[n];
        f[0] = 1;
        for (int i = 0, j = 0, k = 0, cnt = 1; cnt < n; cnt ++ ) {
            int minNum = Math.min(f[i] * 2, Math.min(f[j] * 3, f[k] * 5));
            //最小值的指针后移，注意可能有多个最小值，这些指针要同时后移
            f[cnt] = minNum;
            if (minNum == f[i] * 2) 
                i++;
            if (minNum == f[j] * 3)
                j++;
            if (minNum == f[k] * 5)
                k++;
        }
        return f[n - 1];
    }
}
// @lc code=end

