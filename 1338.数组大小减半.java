import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1338 lang=java
 *
 * [1338] 数组大小减半
 */

// @lc code=start
class Solution {
    public int minSetSize(int[] arr) {
        int l = arr.length, count = 1;//个数初始值为1
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);//排序，方便统计个数
        for(int i = 0; i < l - 1; i++) {
            if(arr[i] == arr[i+1]) {
                count++;//个数+1
            }
            else {
                list.add(count);//将此数的个数添加到list中
                count = 1;//count重置为1
            }
            if(i == l - 2) list.add(count);//添加最后一个数的个数
        }
        Collections.sort(list);//将每个数的个数从小到大排序
        int s = 0, res = 0;
        for(int i = list.size() - 1; i > 0; i--) {
            res++;//要返回的结果
            s += list.get(i);//从个数最多的开始加
            if(s >= l/2) return res;//如果大于数组长度的一半，直接返回
        }
        return 1;
    }
}
// @lc code=end

