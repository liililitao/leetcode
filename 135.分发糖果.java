/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        //哇哈哈哈哈，我凭自己的能力第一次做出了hard难度的题！
        //我写的第一道hard题，也是第一道成功的hard题！
        int l = ratings.length;
        int[] res = new int[l];//这两个数组是给每个孩子发的糖果数
        int[] res2 = new int[l];//一个是从前往后遍历，一个是从后往前遍历
        for(int i = 0; i < l; i++) {
            res[i] = 1;//初始值都置为一，因为每个孩子至少分配到 1 个糖果
            res2[i] = 1;
        }
        for(int i = 1; i < l; i++) {//从前往后遍历
            if(ratings[i - 1] > ratings[i]) {//哪个大就比他旁边的孩子多一个
                res[i - 1] = Math.max(res[i - 1], res[i] + 1);
            }
            else if(ratings[i - 1] < ratings[i]) {//在原来的值和新值之间取最大的
                res[i] = Math.max(res[i], res[i - 1] + 1);
            }
        }
        for(int i = l - 1; i > 0; i--) {//从后往前遍历
            if(ratings[i - 1] > ratings[i]) {
                res2[i - 1] = Math.max(res2[i - 1], res2[i] + 1);
            }
            else if(ratings[i - 1] < ratings[i]) {
                res2[i] = Math.max(res2[i], res2[i - 1] + 1);
            }
        }
        int count = 0;
        for(int i = 0; i < l; i++)//选两个数组中较大的值
            count += Math.max(res[i], res2[i]);
        return count;
    }
}
// @lc code=end

