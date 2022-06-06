/*
 * @lc app=leetcode.cn id=1642 lang=java
 *
 * [1642] 可以到达的最远建筑
 */

// @lc code=start
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        int sum = 0;
        Queue<Integer> que = new PriorityQueue<>();
        for(int i = 1; i < len; i++){
            int div = heights[i]-heights[i-1];
            if(div > 0){
                que.offer(div);
                if(que.size() > ladders){
                    sum += que.poll();
                    if(sum > bricks){
                        return i-1;
                    }
                }
            }
        }
        return len-1;
    }
}
// @lc code=end

