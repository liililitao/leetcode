/*
 * @lc app=leetcode.cn id=2139 lang=java
 *
 * [2139] 得到目标值的最少行动次数
 */

// @lc code=start
class Solution {
    //啊哈哈哈，so easy，不就是超时吗，分分钟搞定！！！
    public int minMoves(int target, int maxDoubles) {
        //思路很简单，就是逆向思维，把target变为1
        if(maxDoubles == 0) return target - 1;
        int count = 0;
        while(target > 1) {
            if(maxDoubles > 0) {//还能用“除以二”这个操作
                count++;//行动次数加1
                if(target % 2 == 0) {//target是偶数
                    target /= 2;//除以二
                    maxDoubles--;//“除以二”这个操作可用次数减1
                }
                else {//target是奇数
                    target--;//减1
                }
            }
            else {//“除以二”这个操作用完了，那就只能用“减1”操作了
                count += target - 1;//加target-1
                break;//跳出循环，这样省了很多时间
            }
        }
        return count;
    }
}
// @lc code=end

