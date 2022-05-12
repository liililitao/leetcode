import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1508 lang=java
 *
 * [1508] 子数组和排序后的区间和
 */

// @lc code=start
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int s = 0;
        List<Integer> list = new ArrayList<>();
        //将所有非空连续子数组的和放到list中
        for(int i = 0; i < n; i++) {//n就是数组的长度
            s = 0;//重置s为0
            for(int j = i; j < n; j++) {
                s += nums[j];
                list.add(s);
            }
        }
        Collections.sort(list);//升序排序
        int sum = 0;
        for(int i = left - 1; i < right; i++) {
            //因为答案可能很大，所以每一次加都要求余，不能到最后再求余
            sum = (sum + list.get(i)) % 1000000007;
        }
        return sum;
    }
}
// @lc code=end

