/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        // 将所有元素转成字符串
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 降序排列
        Arrays.sort(strs, (x, y) -> {
            String xy = x + y;
            String yx = y + x;
            return yx.compareTo(xy);
        });
        if ("0".equals(strs[0])) {
            return "0"; // "00000"
        }
        StringBuilder sb = new StringBuilder();
        for (String num : strs) {
            sb.append(num);
        }
        return sb.toString();
    }
}
// @lc code=end

