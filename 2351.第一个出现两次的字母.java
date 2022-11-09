import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=2351 lang=java
 *
 * [2351] 第一个出现两次的字母
 */

// @lc code=start
class Solution {
    //啊哈哈，简单题真好！
    public char repeatedCharacter(String s) {
        List<Character> list = new ArrayList<>();
        int l = s.length();
        for(int i = 0; i < l; i++) {
            //如果前面已经包含了该字母，则该字母就是最早的出现第二次的字母
            if(list.contains(s.charAt(i)))
                return s.charAt(i);//直接返回答案
            list.add(s.charAt(i));//添加到list中
        }
        return ' ';
    }
}
// @lc code=end

