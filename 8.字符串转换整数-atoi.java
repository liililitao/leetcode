/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0)
            return 0;//判断是否为空字符串
        int i = 0;//字符串索引
        int flag = 1;//正负判断
        int base = 0;//存储转换后数字
        while(s.charAt(i) == ' ') {//去除空格
            i++;
            if(i == s.length())//如果全为空格则直接返回0
                return 0;
        }
        //第一个字符为正负号时
        if(s.charAt(i)=='-' || s.charAt(i)=='+'){
            flag = s.charAt(i++) == '-' ? -1 : 1;
        }
        while(i < s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){//遇到数字  
            if(base > Integer.MAX_VALUE/10 || (base==Integer.MAX_VALUE/10 && s.charAt(i)-'0' > 7)) {//超出范围
                return (flag==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = (s.charAt(i++)-'0') + base*10;//将字符转换为数字 
        }
        return base*flag;
    }
}
// @lc code=end

