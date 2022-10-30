import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2255 lang=java
 *
 * [2255] 统计是给定字符串前缀的字符串数目
 */

// @lc code=start
class Solution {
    //啊哈哈哈哈，我是天才！！！还有谁！！！无敌！！！
    public int countPrefixes(String[] words, String s) {
        //我直接逆向思维
        int l = s.length(), res = 0;
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= l; i++) {//将字符串 s 所有的前缀全部列出来，因为 s 的长度<=10，所以最多十个元素
            list.add(s.substring(0, i));
        }
        //因为words中可能有重复字符串，如果遍历前缀的话会漏掉重复的，那我直接遍历words不就行了
        for(int i = 0; i < words.length; i++) {//遍历words
            if(list.contains(words[i]))//如果是前缀的话
                res++;
        }
        return res;
    }
}
// @lc code=end

