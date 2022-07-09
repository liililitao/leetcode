import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=2206 lang=java
 *
 * [2206] 将数组划分成相等数对
 */

// @lc code=start
class Solution {
    public boolean divideArray(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();//set用于去除重复元素
        for(int i = 0; i < l; i++)
            set.add(nums[i]);
        int l2 = set.size();//l2是不重复元素的数量
        int[] counts = new int[l2];//统计每个元素出现的个数
        for(int i = 0; i < l2; i++)
            counts[i] = 1;//初始值为1
        int j = 0;
        for(int i = 0; i < l - 1; i++) {
            if(nums[i] == nums[i+1]) {
                counts[j]++;//个数加1
            }
            else {
                j++;//下标加1
            }
        }
        for(int i = 0; i < l2; i++)
            if(counts[i] % 2 == 1)//如果有元素的个数为奇数
                return false;//直接false
        return true;
    }
}
// @lc code=end

