/*
 * @lc app=leetcode.cn id=1553 lang=java
 *
 * [1553] 吃掉 N 个橘子的最少天数
 */

// @lc code=start
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int minDays(int n) {
        //剩下0个了返回0天，剩下1个返回1天
        if (n <= 1) return n;

        //检查一下有没有保存的最优解，有的话直接返回
        if (map.containsKey(n)) {
            return map.get(n);
        }
        //初始化一个最大值 用来后面比较
        int min = Integer.MAX_VALUE;
        //吃到条件2成立的情况下需要的天数
        min = Math.min(min, minDays(n / 2) + (n % 2));
        //吃到条件3成立情况下需要的天数
        min = Math.min(min, minDays(n / 3) + (n % 3));

        // +1 是因为你需要一天时间来吃掉1/2或者2/3
        // 或者可以把上面两行代码写成
        //min = Math.min(min, minDays(n / 2)+1 + (n % 2));
        //min = Math.min(min, minDays(n / 3)+1 + (n % 3));
        //那么此处就不需要+1了

        min+=1;
        //把n个橘子吃的天数最优解保存起来 
        map.put(n, min);

        return min;
    }
}
// @lc code=end

