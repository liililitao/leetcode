/*
 * @lc app=leetcode.cn id=1716 lang=java
 *
 * [1716] 计算力扣银行的钱
 */

// @lc code=start
class Solution {
    public int totalMoney(int n) {
        //真是的，能难倒我？！！！
        int sum = 0;
        int k = 1;
        for(int i = 0; i < n / 7; i++) {
            for(int j = k; j < k + 7; j++) {
                sum += j;
            }
            k++;
        }
        for(int i = k; i < n % 7 + k; i++) {
            sum += i;
        }
        return sum;
    }
}
// @lc code=end

