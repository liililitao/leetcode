/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 如果整数集合中的最大数大于或等于目标和，则先出手玩家直接可以赢，返回true。
        if (maxChoosableInteger>=desiredTotal){
            return true;
        }
        // 若整数集合中所有元素和小于目标和，则平局，返回false。
        if ((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal) {
            return false;
        }
        // 考虑每个数字只有两种情况，所以可以使用状态压缩DP，即使用bit位来表示选中状态。
        // 定义状态数组dp[]，索引值表示组合状态，可以体现哪些整数被选取；
        // dp[]数组中元素的值有三种情况：
        //          1、为null，当前整数组合状态还没出现过，需要计算访问。
        //          2、为true，当前整数组合状态已经出现过，直接查找返回true。
        //          3、为false，当前整数组合状态已经出现过，直接查找返回false。
        Boolean[] dp = new Boolean[(1<<maxChoosableInteger)-1];
        return recursion(maxChoosableInteger, desiredTotal,dp,0);
    }
    // 整数集合中最大值不大于20，所有整数和也不会超过int类型，所以用一个int整数类型表示状态。
    public boolean recursion(int maxChoosableInteger, int desiredTotal,Boolean[] dp,int state){
        // 该整数组合状态已存在，直接返回。
        if(dp[state] != null){
            return dp[state];
        }
        // 遍历每一个数，得到所用整数组合情况。
        for (int i = 1; i <= maxChoosableInteger; i++) {
            // 用二进制进行计算，temp表示整数i对应的二进制位所对应的十进制值
            int temp = (1<<i-1);
            // 与整数状态进行二进制与运算，判断该整数i对应的二进制位与已有的整数状态中对应的二进制位进行与操作。
            // 已有状态中二进制位为1，说明已访问了该位。
            if ((temp & state)==0){  // 说明第i个数还没有使用
                // 那么选用这个数是否大于剩余目标值，是的话就返回true，
                // 或者当这个数选中之后还没达到目标值，但是可以断定下一状态返回的是false，那么也返回true。
                if (desiredTotal - i<=0 || !recursion(maxChoosableInteger, desiredTotal-i,dp,state|temp)){
                    dp[state] = true;   // 记录当前组合状态的结果
                    return true;
                }
            }
        }
        dp[state] = false;
        return false;
    }
}
// @lc code=end

