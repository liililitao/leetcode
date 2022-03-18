import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        // 存入HashSet
        Arrays.stream(nums).forEach(
            hash::add
        );
        int max = 0;
        int sum = 0;
        for (int thisNum : nums) {
            // 寻找起点，如果set中存在比当前数字小1的数字，则不是起点，需要继续寻找
            if (hash.contains(thisNum - 1)) {
                continue;
            }
            // 已经找到起点
            else {
                // 计算当前起点的最大长度，并与现有最大值进行比较
                while (hash.contains(thisNum)) {
                    sum++;
                    thisNum++;
                }
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            }
        }
        return max;
    }
}
// @lc code=end

