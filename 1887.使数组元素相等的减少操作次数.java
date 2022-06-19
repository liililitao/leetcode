import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1887 lang=java
 *
 * [1887] 使数组元素相等的减少操作次数
 */

// @lc code=start
class Solution {
    public int reductionOperations(int[] nums) {
        //哇，我是天才啊！！！这题对每一个数的操作次数其实就是看有几个比他小的数
        int l = nums.length, count = 0, k = 0;
        Arrays.sort(nums);//排序
        for(int i = 1; i < l; i++) {
            if(nums[i] != nums[i - 1])//和前一个不相等，说明遇到了一个新的数
                k++;//k代表比nums[i]小的数的个数，遇到了更大的数，所以要加1
            count += k;//不管和前一个相不相等，都要加上对这个数的操作次数，也就是比他小的数的个数
        }
        return count;//所有的操作次数加起来，最后数组全都是最小的那个数
    }
}
// @lc code=end

