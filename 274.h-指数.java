import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    //小意思，难不倒我！！！
    public int hIndex(int[] citations) {
        int n = citations.length;
        //特殊情况：只有一篇论文并且被引用次数不是0，那么h指数就是1
        if(n == 1 && citations[0] != 0) return 1;
        Arrays.sort(citations);//这道题和顺序没关系，所以排序处理
        //h指数 = n的情况：最少引用次数都 >= n，那么h指数就是n
        if(citations[0] >= n) return n;
        for(int h = n - 1; h > 0; h--) {//h指数从大往小试
            //核心代码，非常巧妙！！！
            if(citations[n - h - 1] <= h && citations[n - h] >= h)
                return h;
        }
        return 0;
    }
}
// @lc code=end

