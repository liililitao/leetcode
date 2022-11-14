import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1539 lang=java
 *
 * [1539] 第 k 个缺失的正整数
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        //虽然复杂度有点高，但总算是过了！！！
        List<Integer> list = new ArrayList<>();
        //list用来储存缺失的正整数
        int l = arr.length;
        if(arr[0] != 1) {
            for(int i = 1; i < arr[0]; i++) {
                list.add(i);//把缺失的正整数都放在list中
            }
        }
        for(int i = 1; i < l; i++) {
            if(arr[i] - arr[i - 1] != 1) {
                for(int j = arr[i - 1] + 1; j < arr[i]; j++) {
                    list.add(j);//把缺失的正整数都放在list中
                }
            }
        }
        for(int i = arr[l - 1] + 1; i <= 10000; i++) {
            list.add(i);//把缺失的正整数都放在list中
        }
        return list.get(k - 1);
    }
}
// @lc code=end

