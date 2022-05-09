/*
 * @lc app=leetcode.cn id=1513 lang=java
 *
 * [1513] 浠呭惈 1 鐨勫瓙涓叉暟
 */

// @lc code=start
class Solution {
    public int numSub(String s) {
        int l = s.length();
        long count = 0, res = 0;//要用long类型，因为答案可能会很大，超过int的范围
        for(int i = 0; i < l; i++) {
            if(s.charAt(i) == '1') {
                count++;//统计连续1的个数
            }
            else {
                res += f(count);//f(count)是这一段连续1中子字符串的数目
                count = 0;//重置为0
            }
            if(i == l - 1) res += f(count);//加上最后一段连续1
        }
        return (int)res % (1000000000 + 7);
    }

    long f(long n) {//返回1+2+···+n
        long s = 0;
        for(int i = 1; i <= n; i++)
            s += i;
        return s % (1000000000 + 7);
    }
}
// @lc code=end

