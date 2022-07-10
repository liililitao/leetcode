/*
 * @lc app=leetcode.cn id=2079 lang=java
 *
 * [2079] 给植物浇水
 */

// @lc code=start
class Solution {
    //啊哈哈，so easy!!!
    public int wateringPlants(int[] plants, int capacity) {
        int l = plants.length;
        //水初始值设为浇完植物0后剩的水，步数初始值设为1
        int water = capacity - plants[0], step = 1;
        //从植物1开始，因为植物0水肯定够，水罐的最大容量肯定是比植物需要水的最大值还大
        for(int i = 1; i < l; i++) {
            if(water >= plants[i]) {//水够的话
                step++;//走一步过去
                water -= plants[i];//浇水
            }
            else {//水不够
                step += i;//回到河边
                water = capacity;//装满水
                step += (i+1);//走到植物i
                water -= plants[i];//浇水
            }
        }
        return step;//返回总步数
    }
}
// @lc code=end

