/*
 * @lc app=leetcode.cn id=2007 lang=java
 *
 * [2007] 从双倍数组中还原原数组
 */

// @lc code=start
class Solution {
    public int[] findOriginalArray(int[] changed) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int n = changed.length;
        Arrays.sort(changed);
        for (int i = 0; i < n; i++) {
            mp.put(changed[i], mp.getOrDefault(changed[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (mp.get(changed[i]) > 0) {
                mp.put(changed[i], mp.get(changed[i]) - 1);
                //如果存在两倍的元素
                if (mp.containsKey(changed[i] * 2) && mp.get(changed[i] * 2) > 0) {
                    mp.put(changed[i] * 2, mp.get(changed[i] * 2) - 1);
                    res.add(changed[i]);//添加到list中
                } else {//不存在两倍的元素
                    return new int[0];//直接返回空数组
                }
            }
        }
        int[] ans = new int[n / 2];//list变为数组
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
// @lc code=end

