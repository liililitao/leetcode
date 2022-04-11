/*
 * @lc app=leetcode.cn id=907 lang=java
 *
 * [907] 子数组的最小值之和
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] arr) {
        // 遍历数组，找到每一个位置前面和后面比他小元素的位置
        int n = arr.length;
        int[] lmin = new int[n];
        Arrays.fill(lmin, -1);
        int[] rmin = new int[n];
        Arrays.fill(rmin, n);
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        stk1.push(0); // add first element
        stk2.push(arr.length-1);
        // 前后更小的元素，单调递增栈
        for(int i=1; i<arr.length; i++) {
            // 如果递增加入递减就是找到下一个比他小的
            while(!stk1.isEmpty() && arr[i]<arr[stk1.peek()]) {
                int idx = stk1.pop();
                rmin[idx] = i;
            }
            stk1.push(i);
        }   
        for(int i=arr.length-2; i>=0; i--) {
            // 如果递增加入，如果小就找到前面一个比他小的值
            while(!stk2.isEmpty() && arr[i]<=arr[stk2.peek()]) {
                int idx = stk2.pop();
                lmin[idx] = i;
            }
            stk2.push(i);
        }
        // 然后寻找每一个元素作为最小值的范围 (i-l)*(r-i)*val
        long res = 0;
        int mod = 1000_000_007;
        for(int i=0; i<arr.length; i++) {
            int l = lmin[i];
            int r = rmin[i];
            long sum = (long)(i-l)*(r-i)*arr[i];
            
            res = (res + sum)%mod;
        }
        return (int)res;
    }
}
// @lc code=end

