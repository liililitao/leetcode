import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";  //单词计数以单词后的标点或空格为准，所以要在最后一个单词后加一个标点防止漏掉
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();
        String ans = "";
        int ansfreq = 0;
        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {    
                word.append(Character.toLowerCase(c));         
            } else if (word.length() > 0) { //此时扫描到标点符号或者空格，即一个单词扫描完毕
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }
}
// @lc code=end

