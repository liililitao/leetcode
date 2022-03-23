import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode.cn id=649 lang=java
 *
 * [649] Dota2 参议院
 */

// @lc code=start
class Solution {
    public String predictPartyVictory(String senate) {
        // 初始化两个队列，存储两个阵营的参议员行使权力的顺序
        Queue<Integer> radiant_queue = new LinkedList<Integer>();
        Queue<Integer> dire_queue = new LinkedList<Integer>();
        int n = senate.length();
        // 将两个阵营的参议员行使权力的顺序分别记录在两个队列中
        for (int i = 0; i < n; i++){
            if (senate.charAt(i) == 'R'){
                radiant_queue.offer(i);
            }else{
                dire_queue.offer(i);
            }
        }
        // 模拟行使权力的过程
        // 两个队列都不为空时，一直遍历，直至有一方阵营的参议员全部失去权利
        while (!radiant_queue.isEmpty() && !dire_queue.isEmpty()){
            // 分别弹出队列头的元素，并返回元素的值
            int radiantIndex = radiant_queue.poll(), direIndex = dire_queue.poll();
            if (radiantIndex < direIndex){
                // 该参议员禁止dire阵营成员的权利，因此dire阵营的成员就不用加入队列了
                // （题目假设每一位参议员都足够聪明，所以这里用了贪心的思想，优先将顺序最靠前的敌对成员禁止，否则该成员可能禁止一个我方成员）
                // 而该参议员；仍有权利，因此放到下一轮的位置；
                radiant_queue.offer(radiantIndex + n);
            } else{
                // 和上面一样
                dire_queue.offer(direIndex + n);
            }
        }
        // 到这一步说明至少有一个阵营所有成员都被禁止了，因此若radiant队列空了，说明Dire获胜，反之则Radiant获胜
        return radiant_queue.isEmpty() ? "Dire" : "Radiant";
    }
}
// @lc code=end

