import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1239 lang=java
 *
 * [1239] 串联字符串的最大长度
 */

// @lc code=start
class Solution {
    public int maxLength(List<String> list) {
        return backtrack(list, 0, new boolean[26]);
    }

    private int backtrack(List<String> list, int depth, boolean[] flag) {// 对应字符是否已存在
        if (depth == list.size()) {// 超出范围
            return 0;
        }
        // 不连接第depth个字符串
        int ret1 = backtrack(list, depth + 1, flag);
        // 尝试连接第depth个字符串
        char[] arr = list.get(depth).toCharArray();
        boolean[] nFlag = flag.clone();// 避免改变原数据
        for (char ch : arr) {
            // 已存在，说明第depth个字符串不符合要求
            if (nFlag[ch - 'a']) {
                return ret1;// 返回不连接的最大长度
            }// @pfdvnah
            nFlag[ch - 'a'] = true;// 设为存在
        }
        // 连接第depth个字符串
        int ret2 = backtrack(list, depth + 1, nFlag);// 新的字符集
        return Math.max(ret1, ret2 + arr.length);// 加上当前长度
    }
}

// @lc code=end

