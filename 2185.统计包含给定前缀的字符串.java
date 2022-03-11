/*
 * @lc app=leetcode.cn id=2185 lang=java
 *
 * [2185] 统计包含给定前缀的字符串
 */

// @lc code=start
class Solution {
    public int prefixCount(String[] words, String pref) {
        int l = words.length, lp = pref.length();
        int flag = 1, count = 0;
        for(int i = 0; i < l; i++) {
            flag = 1;//每次进入循环判断前都把flag设置为1
            if(words[i].length() < lp) continue;//这种情况肯定不可能是前缀，后面的都不用执行了，直接判断下一个字符串
            for(int j = 0; j < lp; j++) {
                if(words[i].charAt(j) != pref.charAt(j)) {//不是前缀
                    flag = 0;//flag设为0
                    break;//已经判断出不是前缀了，就直接跳出这一层循环
                }
            }
            if(flag == 1) count++;//符合条件，count+1
        }
        return count;
    }
}
// @lc code=end

