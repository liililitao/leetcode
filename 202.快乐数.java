/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> list = new ArrayList<>();	// 存放出现过的数字
        while(true) {		// 外层循环
            int sum = 0;	// 下一个数字累加和
            while(n != 0) {	// 内层循环
                sum = sum + (n % 10) * (n % 10);	// 平方累加
                n = n / 10;	// 不断除10
            }
            if(sum == 1) {	// 跳出循环条件
                break;
            }
            if(list.contains(sum)) {
                return false;	// 如果出现过便返回false
            } else {
                list.add(sum);	// 未出现则添加至数组中
                n = sum;		// 把下一个数赋值给要循环处理的变量，进入下一个循环
            }
        }
        return true;
    }
}
// @lc code=end

