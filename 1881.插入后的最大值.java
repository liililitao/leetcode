/*
 * @lc app=leetcode.cn id=1881 lang=java
 *
 * [1881] 插入后的最大值
 */

// @lc code=start
class Solution {
    public String maxValue(String n, int x) {
        StringBuffer sb = new StringBuffer();
        int m = n.length(), i = 0;
        if (n.charAt(0) != '-') {//正数
            while (i < m && (int)(n.charAt(i) - '0') >= x)//寻找第一个值小于x的数位
                sb.append(n.charAt(i++));
        } else {//负数
            sb.append(n.charAt(i++));//添加负号
            while (i < m && (int)(n.charAt(i) - '0') <= x)//寻找第一个值大于x的数位
                sb.append(n.charAt(i++));
        }
        sb.append((char)(x + '0'));//添加x
        while (i < m)//添加剩余数字
            sb.append(n.charAt(i++));
        return sb.toString();
    }
}
// @lc code=end

