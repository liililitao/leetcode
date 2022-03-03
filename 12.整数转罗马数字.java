/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        //将7种字符以及6种特殊情况从大到小一一对应写出来
        int values[]=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res="";
        for(int i = 0; i < 13; i++){//将数组全部遍历完
            while(num >= values[i]){
                num -= values[i];
                res += reps[i];//从大到小依次添加
            }
        }
        return res;
    }
}
// @lc code=end

