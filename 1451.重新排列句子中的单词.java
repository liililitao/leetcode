/*
 * @lc app=leetcode.cn id=1451 lang=java
 *
 * [1451] 重新排列句子中的单词
 */

// @lc code=start
class Solution {
    public String arrangeWords(String text) {
        //首字母转小写
        text = text.substring(0,1).toLowerCase() + text.substring(1);
        String[] str = text.split(" ");//每个单词放在字符串数组中
        int l = str.length;
        for(int i = 0; i < l; i++) {//冒泡排序
            for(int j = 0; j < l - 1 - i; j++) {
                if(str[j].length() > str[j + 1].length()) {
                    String t = str[j];//互换
                    str[j] = str[j + 1];
                    str[j + 1] = t;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < l; i++) {//添加到StringBuider
            res.append(str[i]);
            //最后一个单词后面不用空格，其他单词后加空格
            if(i != l - 1) res.append(" ");
        }
        String s = res.toString();
        //首字母转大写
        s = s.substring(0,1).toUpperCase() + s.substring(1);
        return s;
    }
}
// @lc code=end

