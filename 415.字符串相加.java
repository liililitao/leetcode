/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;	// 定位到num1的最后一位
        int j = num2.length() - 1;	// 定位到num2的最后一位
        int plus = 0;	// 进位，不是1就是0
        String s = "";	// 最终答案
        while(i >= 0 || j >= 0) {
            int num = 0;	// 存储当前位相加的和
            if(i < 0) {		// 如果超出num1的索引，那么num2的对应位+进位即可
                num = num2.charAt(j) - '0' + plus;
            } else if(j < 0) {	// 如果超出num2的索引，那么num1的对应位+进位即可
                num = num1.charAt(i) - '0' + plus;
            } else {	// 如果都没超，那么num1的对应位+num2的对应位+进位即可
                num = num2.charAt(j) - '0' + num1.charAt(i) - '0' + plus;
            }
            --i;	// num1索引--
            --j;	// num2索引--
			// 进位处理
            if(num < 10) {
                s = String.valueOf(num) + s;
                plus = 0;
            } else {
                s = String.valueOf(num - 10) + s;
                plus = 1;
            }
        }
        // 若计算完还有进位，则在最前面添加一个 "1"
        if(plus == 1) {
            s = String.valueOf(plus) + s;
        }
        return s;
    }
}
// @lc code=end

