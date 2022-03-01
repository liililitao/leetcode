/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        /*最开始想到的是用一个二维数组，但用二维数组中间有很多空元素，
        而且还要不停的改变数组下标，而用numRows个StringBuffer则可以
        实现和二维数组一样的功能，且只需改变行即可，这样中间就没有空隙，
        直接拼接即可*/
        if(numRows == 1) return s;
        StringBuffer[] str = new StringBuffer[numRows];//定义numRows个StringBuffer
        for(int i = 0; i < numRows; i++)
            str[i] = new StringBuffer();//对每个StringBuffer初始化
        boolean change = true;//判断往上走还是往下走
        for(int i = 0, k = 0; i < s.length(); i++) {
            str[k].append(s.charAt(i));
            if(change) //如果change为真则往下走
                k++;
            else //如果change为假则往上走
                k--;
            if(k == numRows - 1)//到底了，往上走
                change = false;
            if(k == 0)//到顶了，往下走
                change = true;
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < numRows; i++) {
            buffer.append(str[i]);//把所有的StringBuffer拼接起来
        }
        return buffer.toString();
    }
}
// @lc code=end

