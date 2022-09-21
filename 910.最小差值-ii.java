import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=910 lang=java
 *
 * [910] 最小差值 II
 */

// @lc code=start
class Solution {
    /**
    * 数据有n个节点，先排序， 假设m个节点需要向右移动， 那么m-n个节点需要向左移动
    * 那么移动后数组的数组的最大值为 MAX(第m个节点+移动的步数，原来的最大值-移动的步)
    * 最小值为 Min(第一个节点+移动的步数，第m+1个节点-移动的步数)
    * 然后将m的值从 1 到 n 进行遍历， 取出 差值最小值；
    */
    public int smallestRangeII(int[] nums, int k) {
        int l = nums.length;
        Arrays.sort(nums);
        int max = nums[l - 1];
        int min = nums[0];
        int ri = max - min;
        for (int i = 0; i < l - 1; i++) {
            min = Math.min(nums[0] + k, nums[i + 1] - k);
            max = Math.max(nums[i] + k, nums[l - 1] - k);
            ri = Math.min(max - min, ri);
        }
        return ri;
    }
}
// @lc code=end

