import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null||matchsticks.length<4){
            return false;
       }
       //提前判断是否有可能是正方形
       int sum_num=0;
       for(int i:matchsticks){
           sum_num+=i;
       }
       if(sum_num==0||sum_num%4 !=0){
           return false;
       }
       Arrays.sort(matchsticks);//这个排序默认是升序的
       return canMake(matchsticks.length-1,matchsticks,new int[4],sum_num/4);
   }
   //要记录每个边的长度sum[i] pos-数组matchsticks中的位置
   private boolean canMake(int pos,int[]matchsticks,int[]sum,int average){
       if(pos<0){//matchsticks数组遍历完毕
           //是否每个长度都相等
           return (sum[0]==average &&sum[1]==average&&sum[2]==average);
       }
       for(int i=0;i<4;i++){//四条边分别尝试
           if(sum[i]+matchsticks[pos]>average){
               continue;
           }
           sum[i]+=matchsticks[pos];
           if(canMake(pos-1,matchsticks,sum,average)){
               return true;
           }
           //回溯
           sum[i]-=matchsticks[pos];
       }
       return false;
    }
}
// @lc code=end

