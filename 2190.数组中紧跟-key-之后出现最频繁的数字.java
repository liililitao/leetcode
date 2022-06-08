import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2190 lang=java
 *
 * [2190] 数组中紧跟 key 之后出现最频繁的数字
 */

// @lc code=start
class Solution {
    public int mostFrequent(int[] nums, int key) {
        int l = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < l - 1; i++) {
            if(nums[i] == key) {
                list.add(nums[i+1]);//把所有紧跟key后面的数放到list中
            }
        }
        //因为答案肯定唯一，所以只有两个数时这两个数一定相等
        if(list.size() <= 2) return list.get(0);
        //然后就找出list中出现次数最多的数字
        int count = 1, res = 0, max = 0;
        Collections.sort(list);//从小到大排序，方便统计个数
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i-1).equals(list.get(i))) {//相等
                count++;//个数加1
            }
            else {//不相等
                if(count > max) {
                    res = list.get(i-1);//把最终结果放到res中
                    max = count;//更新max
                }
                count = 1;//重置count
            }
            if(count > max) {//相等时也要判断
                res = list.get(i-1);
                max = count;
            }
        }
        return res;
    }
}
// @lc code=end

