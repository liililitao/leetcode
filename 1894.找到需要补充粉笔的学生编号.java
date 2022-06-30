/*
 * @lc app=leetcode.cn id=1894 lang=java
 *
 * [1894] 找到需要补充粉笔的学生编号
 */

// @lc code=start
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        //so easy啦！
        int l = chalk.length, i = 0;
        while(k >= 0) {
            if(i == l)//到最后一个学生
                i = 0;//回到第一个学生
            if(k >= chalk[i]) {
                k -= chalk[i];
                i++;
            }
            else {//粉笔不够，需要补充粉笔
                return i;
            }
        }
        return i;
    }
}
// @lc code=end

