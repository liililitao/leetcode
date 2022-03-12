/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)//任何数的0次幂都是1
            return 1;
        if(n == 1)//任何数的1次幂是他本身
            return x;
        if(n == -1)//任何数的-1次幂是1除以他本身
            return 1/x;
        double half = myPow(x, n/2);//先算x的n/2次方
        double rest = myPow(x, n%2);//n为偶数，rest=1，n为奇数，rest=x
        return rest*half*half;//不管n为偶数还是n为奇数都是正确的
    }
}
// @lc code=end

