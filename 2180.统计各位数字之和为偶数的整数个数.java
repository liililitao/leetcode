/*
 * @lc app=leetcode.cn id=2180 lang=java
 *
 * [2180] 统计各位数字之和为偶数的整数个数
 */

// @lc code=start
class Solution {
    public int countEven(int num) {
        int s = 0, count = 0, r = 0, k = 0;
        for(int i = 2; i <= num; i++) {
            s = 0;//每次进入第二层循环前都要重置s为0
            k = i;//k用来帮助取得i的各位数字，因为i不能变
            while(k != 0) {
                r = k % 10;//各位余数
                s += r;//将各位数字相加
                k /= 10;//k除以10
            }
            if(s % 2 == 0)//符合题目要求
                count++;
        }
        return count;
    }
}
// @lc code=end

