import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start
class Solution {
    public int specialArray(int[] nums) {
        //哇哈哈哈，天才啊！！！
        int l = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i <= 100; i++) {//l最大是100
            for(int j = 0; j < l; j++) {
                if(nums[j] >= i) {
                    if(l - j == i) {
                        return i;
                    }
                    break;//只看第一个大于等于i的元素
                }
            }
        }
        return -1;
    }
}
// @lc code=end

