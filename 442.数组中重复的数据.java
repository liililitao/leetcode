import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);//从小到大排序，这样出现两次的数就在一起了
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {//出现两次的数
                list.add(nums[i]);//添加
            }
        }
        return list;
    }
}
// @lc code=end

