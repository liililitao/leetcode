/*
 * @lc app=leetcode.cn id=1790 lang=java
 *
 * [1790] 仅执行一次字符串交换能否使两个字符串相等
 */

// @lc code=start
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        //so easy啦！！！
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 != l2) return false;
        if(s1.equals(s2)) return true;
        int count = 0;//记录s1和s2有几个不一样的字符
        int t1 = 0, t2 = 0, flag = 0;
        for(int i = 0; i < l1; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(flag == 0) {
                    t1 = i;//第一个不一样字符的索引
                    flag++;
                }
                else t2 = i;//第二个不一样字符的索引
            }
        }
        if(count != 2) return false;//如果不一样的字符不是两个，直接false
        else {
            if(s1.charAt(t1) == s2.charAt(t2) && s1.charAt(t2) == s2.charAt(t1)) 
                return true;//如果交换后相等，则true
            else 
                return false;
        }
    }
}
// @lc code=end

