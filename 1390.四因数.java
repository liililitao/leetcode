/*
 * @lc app=leetcode.cn id=1390 lang=java
 *
 * [1390] 四因数
 */

// @lc code=start
class Solution {
    public int sumFourDivisors(int[] nums) {
        int s = 0, l = nums.length;
        for(int i = 0; i < l; i++) {
            s += f(nums[i]);
        }
        return s;
    }

    int f(int n) {//如果n恰有四个因数，返回他们的和，否则返回0
        int s = 0, count = 0;
        for(int i = 2; i < n; i++) {//1和n自身肯定是因数，不用判断
            if(count > 2) return 0;//多于两个直接返回0
            if(n % i == 0) {
                s += i;//记录和
                count++;//记录个数
            }
        }
        if(count != 2) return 0;//不是四个因数，返回0
        else return s + 1 + n;//要加上1和n自身
    }
}
// @lc code=end

