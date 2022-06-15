import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1996 lang=java
 *
 * [1996] 游戏中弱角色的数量
 */

// @lc code=start
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        }); 
        int max = 0;
        int res = 0;
        for(int[] p : properties){
            if(p[1] < max){
                res ++;
            }else{
                max = p[1];
            }
        }
        return res;
    }
}
// @lc code=end

