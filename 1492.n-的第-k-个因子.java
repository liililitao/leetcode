import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1492 lang=java
 *
 * [1492] n 的第 k 个因子
 */

// @lc code=start
class Solution {
    public int kthFactor(int n, int k) {
        //这啥题，比简单题还简单的题，秒杀！
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(n % i == 0)
                list.add(i);
        }
        if(k > list.size()) return -1;
        return list.get(k - 1);
    }
}
// @lc code=end

