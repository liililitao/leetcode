/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);//将所有人按体重从小到大排序
        int l = 0, r = people.length - 1, ans = 0;//左指针指向轻的人，右指针指向重的人，船的数量
        while (l <= r) {//有人未上船
            if (people[l] + people[r] <= limit)//当前轻的人+重的人不超过船的载重，轻的人可一同上船
                l++;
            r--;//重的人上船
            ans++;//统计船数
        }
        return ans;
    }
}
// @lc code=end

