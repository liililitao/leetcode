/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        int conut = 0;//保存1的个数
        int rem = 0;//保存尾数，方便统计对应位上存在有多少个1
        for(int i = 0; n != 0; i++) {
            int tem = n/10;//当前位前面的数大小
            if(tem * 10 + 1 < n)  tem++;//3421的情况
            else if(tem * 10 + 1 == n) conut += rem + 1;//3420的情况
            conut += (tem * Math.pow(10, i));//对应位的 1 前面的个数
            rem += (n % 10 * Math.pow(10, i));//保存尾数
            n /= 10;
        }
        return conut;
    }
}
// @lc code=end

