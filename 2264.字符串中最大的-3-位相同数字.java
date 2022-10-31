import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2264 lang=java
 *
 * [2264] 字符串中最大的 3 位相同数字
 */

// @lc code=start
class Solution {
    //啊哈哈哈，秒杀！！！唉，简单题就是简单题啊！
    public String largestGoodInteger(String num) {
        int l = num.length();
        List<String> list = new ArrayList<>();
        for(int i = 1; i < l - 1; i++) {//如果连续三个都一样
            if(num.charAt(i - 1) == num.charAt(i) && num.charAt(i) == num.charAt(i + 1))
                list.add(num.substring(i - 1, i + 2));//将这个子字符串添加到list中
        }
        if(list.size() == 0) return "";
        Collections.sort(list);//升序排序
        return list.get(list.size() - 1);//返回最后一个
    }
}
// @lc code=end

