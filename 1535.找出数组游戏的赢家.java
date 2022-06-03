import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1535 lang=java
 *
 * [1535] 找出数组游戏的赢家
 */

// @lc code=start
class Solution {
    public int getWinner(int[] arr, int k) {
        int l = arr.length, counti = 0, countj = 0;
        if(k >= l) {//要求连续赢的回合数比数组长度大，说明所有元素都比了一遍
            Arrays.sort(arr);//那直接返回数组中最大元素就行了
            return arr[l - 1];
        }
        for(int i = 0, j = 1; i < l && j < l;) {
            if(arr[i] > arr[j]) {//i下标的元素比j大
                counti++;//counti表示i连赢的回合数
                if(counti == k)//=k直接返回
                    return arr[i];
                else countj = 0;//countj要清0
                j = Math.max(i, j) + 1;//j要移到下一个元素
            }
            else {//j下标的元素比i大
                countj++;//countj表示j连赢的回合数
                if(countj == k)//=k直接返回
                    return arr[j];
                else counti = 0;//counti要清0
                i = Math.max(i, j) + 1;//i要移到下一个元素
            }
        }
        Arrays.sort(arr);//剩下的情况一律返回数组中最大元素
        return arr[l-1];
    }
}
// @lc code=end

