import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2231 lang=java
 *
 * [2231] 按奇偶性交换后的最大数字
 */

// @lc code=start
class Solution {
    public int largestInteger(int num) {
        // 记录每个数字出现次数
        int[] ns = new int[10];
        // 记录每个位置的奇偶
        boolean[] bs = new boolean[10];
        // idx 为num在数组中最前面的位置 (从后往前)
        int idx = 10, ans = 0, p;
        // 处理数字
        while (num != 0) {
            // 取出最后一位
            p = num % 10;
            // 记录奇偶状态
            bs[--idx] = p % 2 == 0;
            // 记录该数字出现次数
            ns[p]++;
            // 后退一位
            num /= 10;
        }
        // 生成结果 (从前往后)
        while (idx < 10) {
            // 根据奇偶状态选择数字
            p = bs[idx] ? 8 : 9;
            // 找到最大且数量不为0的数
            while (ns[p] == 0) p -= 2;
            // 结果进一位并加上该位值
            ans = ans * 10 + p;
            // 减少出现次数
            ns[p]--;
            // 指向下一位
            idx++;
        }
        return ans;
    }
}
// @lc code=end

