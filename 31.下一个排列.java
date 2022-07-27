import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    //啊哈哈哈哈，我简直就是天才！！！
    public void nextPermutation(int[] nums) {
        /*
         * 具体思路就是从倒数第二个数 i 开始，i 后面的数从最后一个数 j 开始，
         * 一旦出现比 i 大的数，就先把它两交换，然后跳出循环，最后把 i 后面的
         * 数从小到大排序。
         */
        int l = nums.length, flag = 0, k = -1;
        //这里k的初始值置为-1是因为如果不存在下一个更大的排列，那么直接数组升序排列就行，所以k + 1 = 0
        for(int i = l-2; i >= 0; i--) {
            for(int j = l-1; j > i; j--) {
                if(nums[j] > nums[i]) {
                    int t = nums[i];//交换
                    nums[i] = nums[j];
                    nums[j] = t;
                    flag = 1;//置为1表示已经交换过了
                    k = i;//k 用来标记 i
                    break;
                }
            }
            if(flag == 1) break;//如果已经交换过则直接退出循环
        }
        Arrays.sort(nums, k+1, l);//把 k 后面的数从小到大排序
    }
}
// @lc code=end

