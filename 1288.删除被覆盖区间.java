import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> arrList = new ArrayList<>();
        int n = intervals.length;
        for(int i=0;i<n;i++){
            arrList.add(intervals[i]);
        }
        Collections.sort(arrList, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        //左端点升序，右端点降序
                        return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
                    }
         });
        int sum = 0;//记录所有被覆盖的区间数
        int left = arrList.get(0)[0],right = arrList.get(0)[1];
        for(int i=1;i<arrList.size();i++){
            int[] cur = arrList.get(i);
            if(right>=cur[1] && cur[0]>=left){//因为cur[0]一定大于left,所以只要满足cur[1]
                sum++;
            }
            if(right<=cur[1]){//有交集，更新right
                right = cur[1];
            }
            if(cur[0]>=right){
                left = cur[0];
                right = cur[1];
            }
        }
        return n-sum;
    }
}
// @lc code=end

