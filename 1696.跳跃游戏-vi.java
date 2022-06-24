/*
 * @lc app=leetcode.cn id=1696 lang=java
 *
 * [1696] 跳跃游戏 VI
 */

// @lc code=start
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] cost = new int[nums.length]; // cost[i]代表跳跃至nums第i个元素所得到累加和的最大值
        Deque<Integer> deque = new LinkedList<>(); // 双端队列
        // 先把下标为0的元素提前放入deque与cost中
        deque.offer(0);
        cost[0] = nums[0];
        // 开始进行动态规划+单调队列
        for(int i = 1; i < nums.length; ++i) {
            cost[i] = cost[deque.peek()] + nums[i]; // 动态规划
            // 下面为单调队列
            // 注意单调队列里的元素为下标，而“单调”比较的是cost[下标]对应的大小
            if(!deque.isEmpty() && deque.peek() <= i - k) { // deque.peek() <= i - k 说明最大元素已不再滑窗里了
                deque.poll();
            }
            while(!deque.isEmpty() && cost[i] > cost[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);   
        }
        return cost[nums.length - 1];
    }
}
// @lc code=end

