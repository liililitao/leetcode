import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1823 lang=java
 *
 * [1823] 找出游戏的获胜者
 */

// @lc code=start
class Solution {
    public int findTheWinner(int n, int k) {
        //真是的，还搞不定个你了，写了我快一个小时！！
        if(k == 1) return n;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);
        int i = 0;
        while(list.size() > 1) {
            for(int j = 1; j < k; j++) {//从i开始往后数k个人
                i++;
                if(i == list.size()) {//如果超过最后一个人
                    i = 0;//返回到第一个人
                }
            }
            list.remove(i);//移除
            if(i == list.size()) {//如果移除的是最后一个人
                i = 0;//返回到第一个人。否则i不用动，因为移除了一个人，所以i就是移除的那个人的下一个人
            }
        }
        return list.get(0);//返回最后留下的一个人
    }
}
// @lc code=end

