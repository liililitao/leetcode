import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1986 lang=java
 *
 * [1986] 完成任务的最少工作时间段
 */

// @lc code=start
class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int n = tasks.length;
        int left = 1;
        int right = n;
        while(left < right){
            int mid = (left + right) >> 1;
            int[] timeParagraph = new int[mid];
            if(dfs(n - 1,tasks,timeParagraph,mid,sessionTime)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean dfs(int index,int[] tasks,int[] timeParagraph,int mid,int sessionTime){
        if(index == -1) return true;
        boolean[] visible = new boolean[sessionTime + 1];
        //遍历每一个时间段
        for(int i = 0;i < mid;i++){
            //如果前面桶的值已经出现过，就可以跳过该桶，向下一个桶内尝试放入
            if(visible[timeParagraph[i]]) continue;
            visible[timeParagraph[i]] = true;
            int t = timeParagraph[i] + tasks[index];
            if(t <= sessionTime){
                timeParagraph[i] = t;
                if(dfs(index - 1,tasks,timeParagraph,mid,sessionTime)) return true;
                timeParagraph[i] -= tasks[index];
            }
        }
        return false;
    }
}
// @lc code=end

