import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //用List集合的主要目的其实是想用contains方法
        List<Character> list = new ArrayList<>();
        int l = s.length(), res = 0;//res是最后的结果
        for(int i = 0, k = 0; i < l; i++) {
            if(list.contains(s.charAt(i))) {//如果contains，说明遇到了重复元素
                res = Math.max(res, list.size());//取最大值
                list.clear();//清空list，因为要重新计算子串的长度
                k++;//k用来控制从1到l的索引
                i = k;//从第一个元素开始逐个计算无重复元素的子串的长度
            }
            list.add(s.charAt(i));
        }
        //最后还要赋值一下，因为有可能最后一个list是最长的无重复元素的子串
        res = Math.max(res, list.size());
        return res;
    }
}
// @lc code=end

