import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    //终于过了！！！我的天哪！再不过我就快疯了！！！！
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int l = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < l; i++)//利用set去除重复元素
            set.add(nums[i]);
        int n = set.size();
        int[][] count = new int[n][2];//前面是值，后面是该值出现的次数
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);//从小到大排序
        for(int i = 0; i < n; i++) {
            count[i][0] = list.get(i);//值
            count[i][1] = 1;//出现次数初始为1
        }
        Arrays.sort(nums);//排序
        int p = 0;
        for(int i = 0; i < l - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                count[p][1]++;//次数加1
            }
            else {
                p++;//下标加1
            }
        }
        //将所有元素按照出现次数降序排列，之后只需取前k个元素就可以
        for(int i = 0; i < n; i++) {//经典冒泡排序
            for(int j = 0; j < n - 1 - i; j++) {
                if(count[j][1] < count[j + 1][1]) {//将出现次数少的移后面
                    int t1 = count[j][1], t2 = count[j][0];
                    count[j][1] = count[j + 1][1];//值和出现次数都要换
                    count[j][0] = count[j + 1][0];
                    count[j + 1][1] = t1;
                    count[j + 1][0] = t2;
                }
            }
        }
        for(int i = 0; i < k; i++) {//取前k个
            res[i] = count[i][0];
        }
        return res;
    }
}
// @lc code=end

