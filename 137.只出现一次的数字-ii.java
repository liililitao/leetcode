import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int i = 0; i < 32; ++i) {
            int bitnums = 0;
            //二进制向左走一位
            int bit = 1 << i;
            for(int num : nums) {
            //每个数这一位是不是1如果是1就++
                if((num&bit) != 0)
                    bitnums++;
            }
            //如果不能%3的话，证明那个出现过一次的数在这一位是1；
            if(bitnums % 3 != 0)
                ret |= bit;
        }
        return ret;
    }
}
// @lc code=end

