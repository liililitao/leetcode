import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1968 lang=java
 *
 * [1968] 构造元素不等于两相邻元素平均值的数组
 */

// @lc code=start
class Solution {
    public int[] rearrangeArray(int[] nums) {
        //啊哈哈哈，so easy啦！分分钟搞定，秒杀！
        /*其实很简单，要满足题目的要求，只需要按照小大小大小...
         * 或者大小大小大...这样的顺序就ok，因为两个比你小的数
         * 取平均值肯定还是比你小，两个比你大的数取平均值肯定还是比你大
         * 所以这题就很简单了
         */
        int l = nums.length;
        int[] n2 = new int[l];
        Arrays.sort(nums);
        int i = 0, j = l-1, k = 0;
        while(k < l) {//把n2数组填满为止
            if(k % 2 == 0) {
                n2[k] = nums[i];//小
                i++;//左索引加1
            }
            else {
                n2[k] = nums[j];//大
                j--;//右索引减1
            }
            k++;
        }
        return n2;
    }
}
// @lc code=end

