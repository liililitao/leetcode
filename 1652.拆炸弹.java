/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
		int len = code.length;
		if (k == 0) {
			return res;
		} else {
			for (int i = 0; i < code.length; i++) {// 遍历每个元素
				int sum = 0;
				for (int j = 0; j < Math.abs(k); j++) {// 循环k轮
					if (k > 0) {
						// 从 i后面开始找3 个数，也就是i+1开始;
						// (i+1)+j：i后面的第几个数
						// 对数组长度取余，可以作循环（想象成圆）
						sum += code[(i + 1 + j) % len];
					} else {
						sum += code[(len + i - 1 - j) % len];
					}
				}
				res[i] = sum;
			}
		}
		return res;
    }
}
// @lc code=end

