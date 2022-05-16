/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        int la = s.length(), lb = goal.length();
        if(la != lb) return false;//长度不相等直接false
        if(s.equals(goal)) {//这两个字符串一样的情况下
            for(int i = 0; i < la - 1; i++) {
                for(int j = i+1; j < la; j++) {
                    if(s.charAt(i) == s.charAt(j))
                        return true;//有两个一样的字母，返回true
                }
            }
            return false;//没有两个一样的字母，false
        }
        int count = 0;//记录有几个字母不相等
        char t1 = 'a', t2 = 'b', t3 = 'c', t4 = 'd';
        for(int i = 0; i < la; i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                count++;
                if(count == 1) {//第一次不相等的两个字母
                    t1 = s.charAt(i);
                    t2 = goal.charAt(i);
                }
                else {//第二次不相等的两个字母
                    t3 = s.charAt(i);
                    t4 = goal.charAt(i);
                }
            }
            if(count > 2) return false;//超过两个字母不相等，直接false
        }
        if(t1 == t4 && t2 == t3) return true;//满足条件
        return false;
    }
}
// @lc code=end

