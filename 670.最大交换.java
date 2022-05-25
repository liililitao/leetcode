import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        // 保存对应字符的下标
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }
         // 从左向右扫描，找到当前位置右边的最大的数字并交换
        for (int i = 0; i < A.length; i++) {
            // 找最大，所以倒着找
            for (int d = 9; d > A[i] - '0'; d--) {
                // 找到右边的 交换就好了，交换一次就返回
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
// @lc code=end

