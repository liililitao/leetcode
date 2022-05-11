import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1481 lang=java
 *
 * [1481] 不同整数的最少数目
 */

// @lc code=start
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        /*要找出移除后数组中不同整数的最少数目，则要尽可能的多移除数字，
        所以我们把数组中每个整数出现的次数统计出来，从出现次数少的开始移除，
        这样就可保证移除后不同整数的数目最少！ */
        List<Integer> list = new ArrayList<>();
        int l = arr.length, count = 1, res = 0;
        if(l == 1 && k == 1) return 0;
        if(l == 1 && k == 0) return 1;
        Arrays.sort(arr);//排好序，方便统计各个整数出现的次数
        for(int i = 0; i < l - 1; i++) {
            if(arr[i] == arr[i+1]) {
                count++;
            }
            else {
                list.add(count);//list为arr的每个整数出现的次数
                count = 1;//重置为1
            }
            if(i == l - 2) list.add(count);//老规矩
        }
        Collections.sort(list);//把每个整数出现的次数也从小到大排好序
        for(int i = 0; i < l; i++) {
            if(k >= list.get(i)) {//k比它出现的次数大
                res++;//+1
                k -= list.get(i);//k减去它出现的次数
            }
            else break;//不能移了，跳出循环
        }
        return list.size() - res;//总的数目减去移除的数目就是移除后的数目
    }
}
// @lc code=end

