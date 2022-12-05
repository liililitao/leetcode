/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String text) {
        if (text.length() <= 1) return text;
        char[] ch = text.toCharArray();
        int wordCount = 0;      //单词数
        int spaceCount = 0;     //空格数
        for (int i = 0; i < ch.length; i++) {
            //空格数加1
            if (ch[i] == ' ')   spaceCount++;
            //单词数加1
            else if ((i == 0 || ch[i-1] == ' ') && ch[i] != ' ')    wordCount++;
        }
        StringBuilder sb = new StringBuilder();
        //间隔加的空格数
        int num = wordCount == 1 ? spaceCount : spaceCount / (wordCount - 1);
        //遍历数组，进行拼接
        for (int i = 0; i < ch.length; i++) {
            //如果是空格，并且sb为空，进入下个循环
            if (sb.length() == 0 && ch[i] == ' ')   continue;
            //不是空格就插入，插入单词字符
            if (ch[i] != ' ')   sb.append(ch[i]);
            //如果单词插入完毕，进行循环拼接，num个空格
            else if (ch[i] == ' ' && ch[i-1] != ' ')
                for (int j = 0; j < num; j++)
                   sb.append(' ');
        }
        //补空格
        while (sb.length() < text.length()) sb.append(' ');
        //因为for循环里，每次增加单词后，都会加空格，最后一个单词后也加了，所以会多出num个空格
        if (sb.length()>text.length())
            sb.delete(text.length(), sb.length());
        return sb.toString();
    }
}
// @lc code=end

