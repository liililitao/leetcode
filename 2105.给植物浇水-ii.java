/*
 * @lc app=leetcode.cn id=2105 lang=java
 *
 * [2105] 给植物浇水 II
 */

// @lc code=start
class Solution {
    //啊哈哈哈，我是天才，so easy!!!
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = plants.length;
        int count = 0, mid = l / 2;
        int waterA = capacityA, waterB = capacityB;
        for(int i = 0; i < mid; i++) {
            if(waterA >= plants[i]) {//水够
                waterA -= plants[i];//浇水
            }
            else {//水不够
                waterA = capacityA;//补满
                count++;//次数加1
                waterA -= plants[i];//浇水
            }
        }
        for(int i = l-1, j = 0; j < mid; i--, j++) {
            if(waterB >= plants[i]) {//水够
                waterB -= plants[i];//浇水
            }
            else {//水不够
                waterB = capacityB;//补满
                count++;//次数加1
                waterB -= plants[i];//浇水
            }
        }
        if(l % 2 == 0)//偶数个植物
            return count;//直接返回
        else {//奇数个植物，中间那个植物还没浇水
            if(Math.max(waterA, waterB) >= plants[mid])//水够
                return count;//返回
            else//水不够，灌满
                return count+1;//加1
        }
    }
}
// @lc code=end

