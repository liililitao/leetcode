/*
 * @lc app=leetcode.cn id=1626 lang=java
 *
 * [1626] 无矛盾的最佳球队
 */

// @lc code=start
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int res = 0;
        int[][] people = new int[ages.length][2];
        for(int i=0;i<ages.length;i++){
            people[i][0] = ages[i];
            people[i][1] = scores[i];
        }
        numSort(people);//按年龄从小到大排序
        int[] dp = new int[people.length];
        for(int i=0;i<people.length;i++){
            dp[i] = people[i][1];
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(people[j][1]<=people[i][1])
                    dp[i] = Math.max(dp[j]+people[i][1],dp[i]); 
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void numSort(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 升序排列
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
    }
}
// @lc code=end

