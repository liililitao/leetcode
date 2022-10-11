import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    //确定这是困难题？直接最简单粗暴的方法！
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++)
            list.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++)
            list.add(nums2[i]);
        Collections.sort(list);
        int s = list.size();
        if(s % 2 == 0) {
            int k = list.get(s / 2 - 1) + list.get(s / 2);
            res = (double)k / 2;
        }
        else {
            res = list.get(s / 2);
        }
        return res;
    }
}
// @lc code=end

