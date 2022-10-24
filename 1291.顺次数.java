import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1291 lang=java
 *
 * [1291] 顺次数
 */

// @lc code=start
class Solution {
    //啊哈哈哈，这个解法无敌啊！！！
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        //所有的顺次数不就这么多吗（8+7+6+5+4+3+2+1 = 36个），全部放在一个数组里
        int[] all = {12,23,34,45,56,67,78,89,123,234,345,456,567,678,789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};
        //只需要遍历一次，36个数，比其他的解法快不知道几倍
        for(int i = 0; i < all.length; i++) {
            if(all[i] >= low && all[i] <= high)//在范围内
                list.add(all[i]);
        }
        return list;
    }
}
// @lc code=end

