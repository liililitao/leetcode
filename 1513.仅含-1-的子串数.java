/*
 * @lc app=leetcode.cn id=1513 lang=java
 *
 * [1513] 仅含 1 的子串数
 */

// @lc code=start
class Solution {
    public int numSub(String s) {
        int l = s.length();
        long count = 0, res = 0;//Ҫ��long���ͣ���Ϊ�𰸿��ܻ�ܴ󣬳���int�ķ�Χ
        for(int i = 0; i < l; i++) {
            if(s.charAt(i) == '1') {
                count++;//ͳ������1�ĸ���
            }
            else {
                res += f(count);//f(count)����һ������1�����ַ�������Ŀ
                count = 0;//����Ϊ0
            }
            if(i == l - 1) res += f(count);//�������һ������1
        }
        return (int)res % (1000000000 + 7);
    }

    long f(long n) {//����1+2+������+n
        long s = 0;
        for(int i = 1; i <= n; i++)
            s += i;
        return s % (1000000000 + 7);
    }
}
// @lc code=end

