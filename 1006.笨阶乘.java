/*
 * @lc app=leetcode.cn id=1006 lang=java
 *
 * [1006] 笨阶乘
 */

// @lc code=start
class Solution {
    public int clumsy(int n) {
        //我太厉害了，哈哈！
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 6;
        int[] nums = new int[n];
        int k = n;
        for(int i = 0; i < n; i++) {//把小于等于n的数从大到小放在一个数组中
            nums[i] = k;
            k--;
        }
        int s = f(nums[0], nums[1], nums[2]);//给s赋初值
        for(int i = 6; i < n; i += 4) {//从下一个乘号开始
            s -= f(nums[i-2], nums[i-1], nums[i]);//减
        }
        for(int i = 3; i < n; i += 4) {
            s += nums[i];//加单个的那一个数
        }
        if(n % 4 == 1) s -= 1;//余1的话减1
        if(n % 4 == 2) s -= 2;//余2的话减2*1
        return s;
    }
    int f(int a, int b, int c) {
        return a*b/c;//这三个数是乘除，先运算
    }
}
// @lc code=end

