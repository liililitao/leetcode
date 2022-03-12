/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)//�κ�����0���ݶ���1
            return 1;
        if(n == 1)//�κ�����1������������
            return x;
        if(n == -1)//�κ�����-1������1����������
            return 1/x;
        double half = myPow(x, n/2);//����x��n/2�η�
        double rest = myPow(x, n%2);//nΪż����rest=1��nΪ������rest=x
        return rest*half*half;//����nΪż������nΪ����������ȷ��
    }
}
// @lc code=end

