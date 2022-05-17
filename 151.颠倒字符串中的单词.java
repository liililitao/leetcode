/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split("[^\\w]+");//正则表达式，非词字符
        StringBuilder str = new StringBuilder();
        for(int i = ss.length-1; i >= 0; i--) {//反着来
            str.append(ss[i]);
            if(i != 0)//最后一个单词后面不用加空格
                str.append(" ");
        }
        //如果最后有空格，删掉
        if(str.charAt(str.length()-1) == ' ') str.delete(str.length()-1, str.length());
        return str.toString();
    }
}
// @lc code=end

