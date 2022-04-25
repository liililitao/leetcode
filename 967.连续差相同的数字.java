/*
 * @lc app=leetcode.cn id=967 lang=java
 *
 * [967] 连续差相同的数字
 */

// @lc code=start
class Solution {
    List<Integer> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        //先初始化开头第一个字符，进入递归
        for (int i = 1; i <= 9; i++) {
            //如果i+k或者i-k都不是有效的字符，说明当前i不能作为数字的开头
            if (i + k > 9 && i - k < 0)
                continue;
            //进入递归
            DFS(new StringBuilder(String.valueOf(i)), n, k);
        }
        int[] nums = new int[res.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }
    public void DFS(StringBuilder str, int n, int k) {
        //长度到了就进入res
        if (str.length() == n) {
            res.add(Integer.parseInt(str.toString()));
            return;
        }
        //获取str上一个数字是什么
        int num = str.charAt(str.length() - 1) - '0';
        //num+k 可以加入到str中，并且开始递归
        if (num + k < 10) {
            str.append(String.valueOf(num + k));
            DFS(str, n, k);
            str.deleteCharAt(str.length() - 1);
        }
        //num-k 可以加入到str中并且开始递归
        if (num - k >= 0 && k != 0) {
            str.append(String.valueOf(num - k));
            DFS(str, n, k);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
// @lc code=end

