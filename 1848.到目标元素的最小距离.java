import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1848 lang=java
 *
 * [1848] 到目标元素的最小距离
 */

// @lc code=start
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        //so easy啦！！！
        int l = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < l; i++) {
            if(nums[i] == target)
                list.add(Math.abs(i - start));
        }
        int l2 = list.size();
        int[] c = new int[l2];
        for(int i = 0; i < l2; i++) {
            c[i] = list.get(i);
        }
        Arrays.sort(c);
        return c[0];
    }
}
// @lc code=end

