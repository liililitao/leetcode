/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
class Solution {
    public int maxDistToClosest(int[] seats) {
        //啊哈哈哈哈，我太厉害了！！！
        int l = seats.length, count = 0, max = 0;
        //统计连续0的最大个数
        for(int i = 0; i < l; i++) {
            if(seats[i] == 0) {//等于0
                count++;
                max = Math.max(max, count);//取最大值
            }
            else {//等于1
                max = Math.max(max, count);//取最大值
                count = 0;//清零，重新统计
            }
        }
        //接下来要处理第一个是0或者最后一个是0的情况
        int j = 0, k = l - 1, count1 = 0, count2 = 0;
        while(seats[j] == 0) {//第一个是0
            count1++;//统计个数
            j++;
        }
        while(seats[k] == 0) {//最后一个是0
            count2++;//统计个数
            k--;
        }
        //如果开头的连续0或者结尾的连续0大于最大值的一半，则返回这两者中的较大值
        if(count2 > max/2 || count1 > max/2) {
            return count2 > count1 ? count2 : count1;
        }
        //其余情况则是最长连续0在中间的情况
        if(max % 2 == 0) //最大值为偶数
            return max / 2;//直接除以2
        else//最大值为奇数
            return max / 2 + 1;//除以2再+1
    }
}
// @lc code=end

