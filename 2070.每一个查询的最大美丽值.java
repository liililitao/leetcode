import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2070 lang=java
 *
 * [2070] 每一个查询的最大美丽值
 */

// @lc code=start
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int[] d = new int[n];
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]); //注意：这里价格相同时，美丽值降序
        d[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            d[i] = Math.max(d[i - 1], items[i][1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = 0, r = n - 1;
            if (items[r][0] <= queries[i]) {
                res[i] = d[r];
                continue;
            }
            if (items[l][0] > queries[i]) continue;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (items[mid][0] <= queries[i])
                    l = mid + 1;
                else r = mid;
            }
            res[i] = d[l - 1];
        }
        return res;
    }
}
// @lc code=end

