import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2091 lang=java
 *
 * [2091] 从数组中移除最大值和最小值
 */

// @lc code=start
class Solution {
    //啊哈哈哈，so easy啦！！！
    public int minimumDeletions(int[] nums) {
        //无非就是三种删除方法：从前往后删，从后往前删，前后一起删。返回最小的即可
        int l = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < l; i++) 
            list.add(nums[i]);
        Arrays.sort(nums);//排序方便找最大值和最小值
        int min = list.indexOf(nums[0]);//最小值的下标
        int max = list.indexOf(nums[l-1]);//最大值的下标
        if(min < max) {//min在左，max在右，返回三种删除方法的最小值
            return Math.min(Math.min(max + 1, l - min), min + 1 + l - max);
        }
        else {//max在左，min在右，返回三种删除方法的最小值
            return Math.min(Math.min(min + 1, l - max), max + 1 + l - min);
        }
    }
}
// @lc code=end

