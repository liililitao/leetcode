import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int l = nums.length;
        if(l == 2) return nums;//只有两个元素直接返回原数组
        Arrays.sort(nums);//排序
        int k = 0;//控制结果数组索引
        for(int i = 1; i < l - 1; i++) {
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) {//满足条件
                res[k] = nums[i];//放入结果数组
                k++;//下标+1
            }
        }
        if(k == 0) {//一个元素都没放进去，说明只出现一次的那两个元素就是第一个和最后一个
            res[0] = nums[0];
            res[1] = nums[l-1];
        }
        if(k == 1) {//放入了一个元素，说明另一个元素要么是第一个，要么是最后一个
            if(nums[0] == nums[1]) res[1] = nums[l-1];//最后一个
            else res[1] = nums[0];//第一个
        }
        return res;
    }
}
// @lc code=end

