/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n+1];
        List<Integer>[] group = new List[n+1];
        for (int i = 1; i <= n; i++) 
            group[i] = new ArrayList<Integer>();

        // 添加各自的冲突节点
        for (int i = 0; i < dislikes.length; i++) {
            group[dislikes[i][0]].add(dislikes[i][1]);
            group[dislikes[i][1]].add(dislikes[i][0]);
        }

        for (int i = 1; i <= n; i++) {
            // 遍历每一个节点,对其染色(1或2),并验证冲突节点
            if (color[i] == 0 && !dfs(i,1,color,group)) 
                return false;
        }

        return true;
    }
    
    // 染色验证
    private boolean dfs(int curNode,int curColor,int[] color,List<Integer> []group){
        color[curNode] = curColor;  // 为当前节点染色
        // 遍历与当前节点冲突的节点
        for (Integer nextNode : group[curNode]) {
            if (color[nextNode] == curColor) 
                return false;  // 冲突的的两个节点颜色一样,染色失败
            // 节点还没有被染色,递归
            if (color[nextNode] == 0 && !dfs(nextNode,3-curColor,color,group)) 
                return false;
        }
        return true;
    }
}
// @lc code=end

