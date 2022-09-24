/*
 * @lc app=leetcode.cn id=1343 lang=java
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
class Solution {
    //啊哈哈哈，根本难不倒我！！！
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = arr.length;
        int count = 0, sum = 0;
        int i = 0, j = k;//左右指针
        for(int m = 0; m < k; m++) {
            sum += arr[m];//第一个大小为k的子数组的和
        }
        while(j < l) {
            if(sum / k >= threshold) {//满足条件
                count++;
            }
            sum = sum - arr[i] + arr[j];//子数组向右移
            i++;//左指针右移
            j++;//右指针右移
        }
        if(sum / k >= threshold) {//这里还要判断最后一个子数组，因为上个循环里没有判断
            count++;
        }
        return count;
    }
}
// @lc code=end

