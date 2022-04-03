/*
 * @lc app=leetcode.cn id=991 lang=java
 *
 * [991] 坏了的计算器
 */

// @lc code=start
class Solution {
    public int brokenCalc(int startValue, int target) {
        /*反向思考，把s变成t和把t变成s是一样的，那么我们要么t/2，要么t++
        如果t是奇数的话，我们把它+1，如果t是偶数的话，我们直接t/2
        直到t < s，这时我们只能一直加1，不能除以2*/
        if(startValue >= target) //只能减，不能乘2
            return startValue - target;
        int count = 0;
        while(startValue < target) {//s<t的时候
            if(target % 2 == 1) {//奇数
                target++;//+1
            }
            else {//偶数
                target /= 2;//除以2
            }
            count++;//操作数+1
        }
        count += (startValue - target);//t<s，t一直+1
        return count;
    }
}
// @lc code=end

