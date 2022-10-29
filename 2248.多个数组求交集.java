import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2248 lang=java
 *
 * [2248] 多个数组求交集
 */

// @lc code=start
class Solution {
    //啊哈哈哈，终于做出来了！！！
    public List<Integer> intersection(int[][] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int l = nums.length;
        Set<Integer> set = new HashSet<>();//set用来去除重复元素
        for(int i = 0; i < l; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums[i].length; j++) {
                set.add(nums[i][j]);
                list.add(nums[i][j]);
            }
            lists.add(list);//将二维数组转化为list，主要是想用contains方法
        }
        List<Integer> res = new ArrayList<>(set);
        for(int i = 0; i < res.size(); i++) {//对所有非重复元素进行遍历
            for(int j = 0; j < l; j++) {
                if(!lists.get(j).contains(res.get(i))) {//如果不包含这个数
                    res.remove(i);//不符合条件，直接移除
                    i--;//移除后元素少一，所以要索引减一
                    break;//该数移除后直接跳出内层循环看下一个数，后面的数组出没出现过这个数都无所谓了
                }
            }
        }
        Collections.sort(res);//升序排列
        return res;
    }
}
// @lc code=end

