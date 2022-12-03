/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        if(num == 0) {	// 排除特殊情况0
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while(num != 0) {
            int remainder = num & 15;	// 15即二进制的1111，这步操作是取后四位数
            if(remainder < 10) {	// 如果在0-9则把该数字添加到StringBuffer的头位
                sb.insert(0, remainder);
            } else {	// 如果在10-15则转换成a-f，用字符'a'作为基准来进行运算
                sb.insert(0, (char)(remainder - 10 + 'a'));
            }
            num = num >>> 4;	// 无符号右移四位
        }
        return sb.toString();
    }
}
// @lc code=end

