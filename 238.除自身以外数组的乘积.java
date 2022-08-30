/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    //不让用除法？我就要用！！！
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length, s = 1;
        int[] res = new int[l];
        for(int i = 0; i < l; i++) {
            s *= nums[i];//所有元素的乘积
        }
        for(int i = 0; i < l; i++) {
            if(nums[i] == 0) {//除数不能为0，只能用笨方法了
                int s1 = 1;
                for(int j = 0; j < i; j++) {
                    s1 *= nums[j];//前面的数的乘积
                }
                for(int j = i + 1; j < l; j++) {
                    s1 *= nums[j];//后面的数的乘积
                }
                res[i] = s1;
                continue;
            }
            res[i] = s / nums[i];//除，嘻嘻嘻
        }
        return res;
    }
}
// @lc code=end

