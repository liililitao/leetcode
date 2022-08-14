/*
 * @lc app=leetcode.cn id=932 lang=java
 *
 * [932] 漂亮数组
 */

// @lc code=start
class Solution {
    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N) {
        memo = new HashMap<>();
        memo.put(1, new int[]{1});
        return f(N);
    }

    private int[] f(int N){
        if(!memo.containsKey(N)){
            int index = 0;
            int[] res = new int[N];
            for(int x : f((N + 1) / 2)){//奇数
                res[index++] = 2 * x - 1;
            }
            for(int x : f(N / 2)){//偶数
                res[index++] = 2 * x;
            }
            memo.put(N, res);
        }
        return memo.get(N);
    }
}
// @lc code=end

