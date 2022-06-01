import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1561 lang=java
 *
 * [1561] 你可以获得的最大硬币数目
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] piles) {
        //so easy啦，从小到大排好序后，从倒数第二个开始，每次隔一个加一次
        int l = piles.length;
        int s = 0, count = l / 3, k = l - 2;
        Arrays.sort(piles);
        for(int i = 0; i < count; i++) {//加l/3次
            s += piles[k];
            k -= 2;//隔一个加，因为Alice会拿走最多的
        }
        return s;
    }
}
// @lc code=end

