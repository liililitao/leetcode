import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=825 lang=java
 *
 * [825] 适龄的朋友
 */

// @lc code=start
class Solution {
    public int numFriendRequests(int[] ages) {
        //第三个条件没用，满足第三个条件的话则一定满足第二个条件
        Arrays.sort(ages);//先排序
        int n  = ages.length;
        int left = 0,right = 0,result=0;
        for(int age : ages){
            if(age < 15){
            // 不考虑15岁以下的，这是题目隐藏条件
                continue;// 后面程序不执行，继续foreach循环，读取数据。
            }
            while(ages[left] <= 0.5*age +7){// 太小的，不合适，left++，范围缩小
                left++;
            }
            while(right+1 < n && ages[right+1] <= age){// 年龄合适
                right++;
            }
            result += right - left;// 累计每个人的发出好友请求 
        }
        return result;// 返回所有人发送好友请求的信息条数。
    }
}
// @lc code=end

