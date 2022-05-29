import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        //哇哈哈哈哈，hard难度的题也不过如此
        //这是我第二次凭自己的能力做出了hard题！
        Set<Integer> set = new HashSet<>();//set集合，目的是去除重复元素
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);//添加到set中
        int l = set.size();
        List<Integer> list = new ArrayList<>(set);//list集合，目的是获取集合中的值和排序
        Collections.sort(list);//排序
        if(!list.contains(1))
            return 1;//如果没有1，直接返回1就行了
        int flag = 1;//这个flag真的是用的非常巧妙！
        for(int i = 0; i < l; i++) {
            if(list.get(i) > 0) {//大于0
                if(list.get(i) == flag) {
                    flag++;//加1
                }
                else {//从1开始加，一旦没有，直接返回，肯定是缺失的第一个正数
                    return flag;
                }
            }
        }
        return flag;//返回flag
    }
}
// @lc code=end

