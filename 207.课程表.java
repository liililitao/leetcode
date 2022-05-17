/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //index数组表示是说对于入度出现的次数。
        int [] index=new int [numCourses];
        List<List<Integer>> lists=new ArrayList<>();
        //用来存放的是对应位置有多少的课程依赖于其下标值。
        Queue<Integer> queue=new LinkedList<>();
        //队列中进入的也都是入度为0的值。
        for(int i=0;i<numCourses;i++){
            lists.add(new ArrayList<>());
        }
        for(int [] cp: prerequisites){
        //对于每一个对应的入度++；
            index[cp[0]]++;
            lists.get(cp[1]).add(cp[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(index[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
        //入度为0的进行取出来，看那些课程由他作为先驱。
            int current=queue.poll();
            for(int q: lists.get(current)){
                if(--index[q]==0)
                    queue.add(q);
            }
            numCourses--;
        }
        return  numCourses==0;
    }
}
// @lc code=end

