/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        //一次过啊哈哈哈我是天才！
        int l = candyType.length;
        int count = 1;
        Arrays.sort(candyType);//先排序
        for(int i = 0; i < l - 1; i++) {
            if(candyType[i] != candyType[i + 1]) {
                count++;//统计有几种不同的糖果，即有几个不同的数字
            }
        }
        if(count >= l/2)return l/2;//如果大于能获得的最大糖果数，则返回能获得的最大糖果数
        else return count;//如果小于能获得的最大糖果数，则返回不同糖果的数量
    }
}
// @lc code=end

