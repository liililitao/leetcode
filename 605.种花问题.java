/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //把能种花的0都变成1，方便后续判断
        int len=flowerbed.length;
        int grownum=0;//统计能种入花的朵数
        if(n==0)
            return true;
        if(len==0)
            return false;
        if(len==1)
            return flowerbed[0]==0 && n==1;
        if(flowerbed[0]==0 && flowerbed[1]==0){//第一个和第二个都是0，则第一个0能种花
            flowerbed[0]=1;
            ++grownum;
        }
        if(flowerbed[len-1]==0 && flowerbed[len-2]==0){
            flowerbed[len-1]=1;//倒数第一个和倒数第二个都是0，则倒数第一个0能种花
            ++grownum;
        }
        for(int i=1;i<len-1;++i){
            if(flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;//连续三个0，则中间那个0能种花
                ++grownum;
            }
        }
        if(grownum>=n)
            return true;
        return false;
    }
}
// @lc code=end

