import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 */

// @lc code=start
class Solution {
    //嘿嘿嘿，一遍过！！！和之前一道题思路一样，就是统计每个元素出现的次数
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int l = nums.length;
        for(int i = 0; i < l; i++)
            set.add(nums[i]);//利用set去除重复元素
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);//排序
        int[][] count = new int[set.size()][2];
        for(int i = 0; i < set.size(); i++) {
            count[i][0] = list.get(i);//前面是值
            count[i][1] = 1;//后面是出现的次数，初始为1
        }
        Arrays.sort(nums);//排序
        int k = 0;
        for(int i = 0; i < l - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                count[k][1]++;//出现次数+1
            }
            else {
                k++;//下标+1
            }
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i][1] > l / 3)//满足条件
                res.add(count[i][0]);//添加
        }
        return res;
    }
}
// @lc code=end

