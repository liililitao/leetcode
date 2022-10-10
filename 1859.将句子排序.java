/*
 * @lc app=leetcode.cn id=1859 lang=java
 *
 * [1859] 将句子排序
 */

// @lc code=start
class Solution {
    //简单，都是一些基本操作
    public String sortSentence(String s) {
        String[] word = s.split(" ");//split老朋友了
        StringBuffer str = new StringBuffer();
        int l = word.length;
        char k = '1';//从 1 开始的单词位置索引
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                int n = word[j].length();
                if(word[j].charAt(n - 1) == k) {
                    str.append(word[j]);
                    str.append(" ");//每添加一个单词后面加一个空格
                    k++;//索引加 1
                    break;//找到了直接跳出这层循环找下一个
                }
            }
        }
        str.deleteCharAt(str.length() - 1);//删除最后一个空格
        //将所有的数字删除，利用正则表达式
        return str.toString().replaceAll("\\d+", "");
    }
}
// @lc code=end

